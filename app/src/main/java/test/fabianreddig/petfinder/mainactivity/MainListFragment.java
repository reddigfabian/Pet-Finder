package test.fabianreddig.petfinder.mainactivity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import test.fabianreddig.petfinder.R;
import test.fabianreddig.petfinder.api.PetFinderApi;
import test.fabianreddig.petfinder.common.adapters.ListPaginatedAdapter;
import test.fabianreddig.petfinder.common.fragments.PaginatedFragment;
import test.fabianreddig.petfinder.databinding.FragmentMainListBinding;
import test.fabianreddig.petfinder.mainactivity.viewmodels.MainListItemViewModel;
import test.fabianreddig.petfinder.mainactivity.viewmodels.PetListModel;

/**
 * Created by WillowTree, Inc. on 4/10/16.
 */
public class MainListFragment extends PaginatedFragment implements SwipeRefreshLayout.OnRefreshListener{
    private static final String TAG = MainListFragment.class.getName();
    private static final String PAGINATE_ACTION = TAG + "_PAGINATE";

    FragmentMainListBinding fragmentMainListBinding;
    String currentLocation;

    private boolean isRefreshing;

    public static MainListFragment newInstance(){
        return new MainListFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        currentLocation = "27560"; //// TODO: 4/10/16 Allow changing of this in app
        databindingSetup(container);
        return fragmentMainListBinding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerSetup();
        Bundle args = getArguments();
        if(args != null && getArguments().getInt(MainListItemViewModel.EXTRA_POSITION,0)>0){
            int currentPosition = savedInstanceState.getInt(MainListItemViewModel.EXTRA_POSITION);
            while(currentPosition>(page*Integer.parseInt(PetFinderApi.ConstantQueryParams.COUNT_VALUE))){
                paginate(++page);// Still working on this
            }
            fragmentMainListBinding.swipeableRecyclerMain.recycler.scrollToPosition(currentPosition);
        }else{
            refresh(false);
        }
    }

    @Override
    public void onDestroyView() {
        savePosition();
    }

    private void savePosition(){
        Bundle args = new Bundle();
        int [] currentPosition = new int[2];
        ((StaggeredGridLayoutManager) fragmentMainListBinding.swipeableRecyclerMain.recycler.getLayoutManager()).findFirstCompletelyVisibleItemPositions(currentPosition);
        args.putInt(MainListItemViewModel.EXTRA_POSITION, currentPosition[0]);
        this.setArguments(args);
    }



    @Override
    public void update() {
        if (fragmentMainListBinding != null && fragmentMainListBinding.swipeableRecyclerMain.recycler.getAdapter() != null) {
            fragmentMainListBinding.swipeableRecyclerMain.recycler.getAdapter().notifyDataSetChanged();
        }
    }


    private void refresh(boolean swipeRefresh){
        getParentPetListModel().clearModels();
        if(!swipeRefresh){
            if(!isRefreshing){
                isRefreshing = true;
                paginate(page=0);
            }else{
                fragmentMainListBinding.swipeableRecyclerMain.refresh.setRefreshing(false);
            }
        }else{
            paginate(page=0);
        }
    }

    private void databindingSetup(ViewGroup container){
        fragmentMainListBinding = DataBindingUtil.inflate(LayoutInflater.from(getActivity()), getLayoutId(), container, false);
        fragmentMainListBinding.setListModel(getParentPetListModel());
        fragmentMainListBinding.executePendingBindings();
    }

    private void recyclerSetup(){
        fragmentMainListBinding.swipeableRecyclerMain.refresh.setOnRefreshListener(this);
        ((ListPaginatedAdapter) fragmentMainListBinding.swipeableRecyclerMain.recycler.getAdapter()).setPaginateAction(getPaginationAction());
    }

    private void petFind(int page){
        int offset = page*Integer.parseInt(PetFinderApi.ConstantQueryParams.COUNT_VALUE);
        addSubscription(getParentPetListModel().petFind(currentLocation, offset).subscribe(aBoolean -> {
            isRefreshing = false;
            fragmentMainListBinding.swipeableRecyclerMain.refresh.setRefreshing(false);
        }));
    }

    private PetListModel getParentPetListModel() {
        return ((MainActivity) getAppCompatActivity()).getPetListModel();
    }

    @Override
    public void onRefresh() {
        refresh(true);
    }

    @Override
    public String getPaginationAction() {
        return PAGINATE_ACTION;
    }

    @Override
    public void paginate(int page) {
        petFind(page);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main_list;
    }
}
