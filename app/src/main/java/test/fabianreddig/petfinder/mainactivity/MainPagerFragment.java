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
import test.fabianreddig.petfinder.mainactivity.viewmodels.PetListViewModel;

/**
 * Created by WillowTree, Inc. on 4/14/16.
 */
public class MainPagerFragment extends BaseFragment {

    FragmentMainPagerBinding fragmentMainPagerBinding;

    public static MainPagerFragment newInstance(int selectedPosition){
        MainPagerFragment frag = new MainPagerFragment();
        Bundle args = new Bundle();
        args.putInt(MainListItemViewModel.EXTRA_POSITION, selectedPosition);
        frag.setArguments(args);
        return frag;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        databindingSetup(container);
        return fragmentMainPagerBinding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if(getParentPetListModel().getCurrentPosition() != fragmentMainPagerBinding.pager.getCurrentItem()){
            getParentPetListModel().setWasPaged(true);
        }
        getParentPetListModel().setCurrentPosition(fragmentMainPagerBinding.pager.getCurrentItem()); // TODO: 4/15/16 Consider setting position on scroll
    }

    private void databindingSetup(ViewGroup container){
        fragmentMainPagerBinding = DataBindingUtil.inflate(LayoutInflater.from(getActivity()), getLayoutId(), container, false);
        PetListViewModel listModel = getParentPetListModel();
        fragmentMainPagerBinding.setListModel(listModel);
        fragmentMainPagerBinding.pager.setAdapter(new DetailPagerAdapter(getChildFragmentManager(), listModel.getPetCount()));
        fragmentMainPagerBinding.pager.setCurrentItem(getArguments().getInt(MainListItemViewModel.EXTRA_POSITION));
        getParentPetListModel().setCurrentPosition(getArguments().getInt(MainListItemViewModel.EXTRA_POSITION));
        fragmentMainPagerBinding.executePendingBindings();
    }

    private PetListViewModel getParentPetListModel() {
        return ((MainActivity) getAppCompatActivity()).getPetListViewModel();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main_pager;
    }
}
