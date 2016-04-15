package test.fabianreddig.petfinder.mainactivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.LocalBroadcastManager;

import javax.inject.Inject;

import me.tatarka.bindingcollectionadapter.BR;
import test.fabianreddig.petfinder.PetFinderApplication;
import test.fabianreddig.petfinder.R;
import test.fabianreddig.petfinder.common.CustomItemViewSelector;
import test.fabianreddig.petfinder.common.activities.BaseActivity;
import test.fabianreddig.petfinder.mainactivity.viewmodels.MainListItemViewModel;
import test.fabianreddig.petfinder.mainactivity.viewmodels.PetListModel;

public class MainActivity extends BaseActivity{
    private static final String TAG = MainActivity.class.getName();

    @Inject
    LocalBroadcastManager broadcastManager;

    private PetListModel petListModel;

    BroadcastReceiver petClickedReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            switchFragment(MainPagerFragment.newInstance(intent.getIntExtra(MainListItemViewModel.EXTRA_POSITION,0)));
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PetFinderApplication.applicationComponent().inject(this);
        petListModel = new PetListModel(new CustomItemViewSelector<>(BR.viewModel));
        switchFragment(MainListFragment.newInstance());
    }

    @Override
    protected void onResume() {
        super.onResume();
        broadcastManager.registerReceiver(petClickedReceiver, new IntentFilter(MainListItemViewModel.ON_PET_CLICKED));
    }

    @Override
    protected void onPause() {
        super.onPause();
        broadcastManager.unregisterReceiver(petClickedReceiver);
    }

    public void switchFragment(Fragment frag){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.main_fragment_holder, frag).addToBackStack("bllop").commit();// TODO: 4/15/16 Proper fragment tagging
    }

    public PetListModel getPetListModel() {
        return petListModel;
    }
}
