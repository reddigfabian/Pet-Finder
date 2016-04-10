package test.fabianreddig.petfinder.mainactivity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import test.fabianreddig.petfinder.R;
import test.fabianreddig.petfinder.common.activities.BaseActivity;

public class MainActivity extends BaseActivity {

    private static final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Fragment newFragment = MainListFragment.newInstance();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.main_fragment_holder, newFragment).commit();
    }
}
