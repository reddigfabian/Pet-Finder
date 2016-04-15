package test.fabianreddig.petfinder.mainactivity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import test.fabianreddig.petfinder.R;
import test.fabianreddig.petfinder.common.fragments.BaseFragment;
import test.fabianreddig.petfinder.databinding.FragmentPetDetailBinding;
import test.fabianreddig.petfinder.mainactivity.viewmodels.MainListItemViewModel;

/**
 * Created by WillowTree, Inc. on 4/10/16.
 */
public class PetDetailFragment extends BaseFragment{

    private MainListItemViewModel mainListItemViewModel;
    FragmentPetDetailBinding fragmentMainPetDetailBinding;

    public static PetDetailFragment newInstance(int position){
        PetDetailFragment petDetailFragment = new PetDetailFragment();
        Bundle args = new Bundle();
        args.putInt(MainListItemViewModel.EXTRA_POSITION, position);
        petDetailFragment.setArguments(args);
        return petDetailFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainListItemViewModel = ((MainActivity) getAppCompatActivity()).getPetListModel().getModels().get(getArguments().getInt(MainListItemViewModel.EXTRA_POSITION));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        databindingSetup(container);
        return fragmentMainPetDetailBinding.getRoot();
    }

    private void databindingSetup(ViewGroup container){
        fragmentMainPetDetailBinding = DataBindingUtil.inflate(LayoutInflater.from(getActivity()), getLayoutId(), container, false);
        fragmentMainPetDetailBinding.setViewModel(mainListItemViewModel);
        fragmentMainPetDetailBinding.executePendingBindings();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_pet_detail;
    }
}
