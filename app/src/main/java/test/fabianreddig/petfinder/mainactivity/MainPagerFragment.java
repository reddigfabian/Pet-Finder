package test.fabianreddig.petfinder.mainactivity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import test.fabianreddig.petfinder.R;
import test.fabianreddig.petfinder.common.fragments.BaseFragment;
import test.fabianreddig.petfinder.databinding.FragmentMainPagerBinding;
import test.fabianreddig.petfinder.mainactivity.viewmodels.MainListItemViewModel;
import test.fabianreddig.petfinder.mainactivity.viewmodels.PetListModel;

/**
 * Created by WillowTree, Inc. on 4/14/16.
 */
public class MainPagerFragment extends BaseFragment {

    FragmentMainPagerBinding fragmentMainPagerBinding;

    public static MainPagerFragment newInstance(int position){
        MainPagerFragment mainPagerFragment = new MainPagerFragment();
        Bundle args = new Bundle();
        args.putInt(MainListItemViewModel.EXTRA_POSITION, position);
        mainPagerFragment.setArguments(args);
        return mainPagerFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        databindingSetup(container);
        return fragmentMainPagerBinding.getRoot();
    }

    private void databindingSetup(ViewGroup container){
        fragmentMainPagerBinding = DataBindingUtil.inflate(LayoutInflater.from(getActivity()), getLayoutId(), container, false);
        PetListModel listModel = getParentPetListModel();
        fragmentMainPagerBinding.setListModel(listModel);
        fragmentMainPagerBinding.pager.setAdapter(new DetailPagerAdapter(getChildFragmentManager(), listModel.getModels().size()));
        fragmentMainPagerBinding.pager.setCurrentItem(getArguments().getInt(MainListItemViewModel.EXTRA_POSITION));
        fragmentMainPagerBinding.executePendingBindings();
    }

    private PetListModel getParentPetListModel() {
        return ((MainActivity) getAppCompatActivity()).getPetListModel();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main_pager;
    }
}
