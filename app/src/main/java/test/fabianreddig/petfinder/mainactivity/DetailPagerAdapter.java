package test.fabianreddig.petfinder.mainactivity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by WillowTree, Inc. on 4/14/16.
 */
public class DetailPagerAdapter extends FragmentPagerAdapter {
    private int count;

    public DetailPagerAdapter(FragmentManager fm, int count) {
        super(fm);
        this.count = count;
    }


    @Override
    public int getCount() {
        return count;
    }

    @Override
    public Fragment getItem(int position) {
        return PetDetailFragment.newInstance(position);
    }
}
