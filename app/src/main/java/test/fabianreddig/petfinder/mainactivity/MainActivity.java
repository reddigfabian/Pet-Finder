package test.fabianreddig.petfinder.mainactivity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import me.tatarka.bindingcollectionadapter.BR;
import rx.Observer;
import test.fabianreddig.petfinder.PetFinderApplication;
import test.fabianreddig.petfinder.R;
import test.fabianreddig.petfinder.api.IPetFinderApi;
import test.fabianreddig.petfinder.api.models.Petfinder;
import test.fabianreddig.petfinder.common.CustomItemViewSelector;
import test.fabianreddig.petfinder.common.viewmodels.ListModel;
import test.fabianreddig.petfinder.common.viewmodels.MainListItemViewModel;
import test.fabianreddig.petfinder.databinding.ActivityMainBinding;
import test.fabianreddig.petfinder.util.RxUtil;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();

    @Inject
    IPetFinderApi petFinderApi;

    ActivityMainBinding activityMainBinding;
    ListModel<MainListItemViewModel> listModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PetFinderApplication.applicationComponent().inject(this);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        listModel = new ListModel<>(new CustomItemViewSelector<>(BR.viewModel));
        activityMainBinding.setListModel(listModel);
        activityMainBinding.executePendingBindings();
    }

    @Override
    protected void onResume() {
        super.onResume();
        petFinderApi.petFind("27560").compose(RxUtil.backgroundToMainThread()).subscribe(new Observer<Petfinder>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Petfinder petfinder) {
                List<MainListItemViewModel> petModels = new ArrayList<>();
                for (Petfinder.Pet pet : petfinder.getPets()) {
                    petModels.add(new MainListItemViewModel(pet));
                }
                listModel.addModels(petModels);
                activityMainBinding.executePendingBindings();
            }
        });
    }
}
