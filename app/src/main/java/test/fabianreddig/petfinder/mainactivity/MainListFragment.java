package test.fabianreddig.petfinder.mainactivity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import test.fabianreddig.petfinder.R;
import test.fabianreddig.petfinder.api.PetFinderApi;
import test.fabianreddig.petfinder.common.adapters.ListPaginatedAdapter;
import test.fabianreddig.petfinder.common.fragments.PaginatedFragment;
import test.fabianreddig.petfinder.databinding.FragmentMainListBinding;
import test.fabianreddig.petfinder.mainactivity.viewmodels.PetListViewModel;

/**
 * Created by WillowTree, Inc. on 4/10/16.
 */
public class MainListFragment extends PaginatedFragment implements SwipeRefreshLayout.OnRefreshListener{
    private static final String TAG = MainListFragment.class.getName();
    private static final String PAGINATE_ACTION = TAG + "_PAGINATE";

    private boolean isFirstRun;
    private int rememberPosition;

    FragmentMainListBinding fragmentMainListBinding;
    String currentLocation;

    private boolean isRefreshing;

    public static MainListFragment newInstance(){
        return new MainListFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        isFirstRun = true;
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
    }

    @Override
    public void onResume() {
        super.onResume();
        if(isFirstRun){
            isFirstRun = false;
            refresh(false);
        }else if(getParentPetListViewModel().isWasPaged()){
            fragmentMainListBinding.swipeableRecyclerMain.recycler.scrollToPosition(getParentPetListViewModel().getCurrentPosition());
            getParentPetListViewModel().setWasPaged(false);
        }
    }

    @Override
    public void update() {
        if (fragmentMainListBinding != null && fragmentMainListBinding.swipeableRecyclerMain.recycler.getAdapter() != null) {
            fragmentMainListBinding.swipeableRecyclerMain.recycler.getAdapter().notifyDataSetChanged();
        }
    }


    private void refresh(boolean swipeRefresh){
        getParentPetListViewModel().clearList();
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
        fragmentMainListBinding.setPetListViewModel(getParentPetListViewModel());
        fragmentMainListBinding.executePendingBindings();
    }

    private void recyclerSetup(){
        fragmentMainListBinding.swipeableRecyclerMain.refresh.setOnRefreshListener(this);
        ((ListPaginatedAdapter) fragmentMainListBinding.swipeableRecyclerMain.recycler.getAdapter()).setPaginateAction(getPaginationAction());
    }

    private void petFind(int page){
        int offset = page*Integer.parseInt(PetFinderApi.ConstantQueryParams.COUNT_VALUE);
        addSubscription(getParentPetListViewModel().petFind(currentLocation, offset).subscribe(aBoolean -> {
            isRefreshing = false;
            fragmentMainListBinding.swipeableRecyclerMain.refresh.setRefreshing(false);
        }));
    }

    private PetListViewModel getParentPetListViewModel(){
        return ((MainActivity) getAppCompatActivity()).getPetListViewModel();
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
