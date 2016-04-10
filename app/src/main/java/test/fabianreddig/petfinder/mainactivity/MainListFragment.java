package test.fabianreddig.petfinder.mainactivity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.tatarka.bindingcollectionadapter.BR;
import test.fabianreddig.petfinder.R;
import test.fabianreddig.petfinder.api.PetFinderApi;
import test.fabianreddig.petfinder.common.CustomItemViewSelector;
import test.fabianreddig.petfinder.common.adapters.ListPaginatedAdapter;
import test.fabianreddig.petfinder.common.fragments.PaginatedFragment;
import test.fabianreddig.petfinder.databinding.FragmentMainListBinding;
import test.fabianreddig.petfinder.mainactivity.viewmodels.PetListModel;

/**
 * Created by WillowTree, Inc. on 4/10/16.
 */
public class MainListFragment extends PaginatedFragment implements SwipeRefreshLayout.OnRefreshListener{
    private static final String TAG = MainListFragment.class.getName();
    private static final String PAGINATE_ACTION = TAG + "_PAGINATE";

    FragmentMainListBinding fragmentMainListBinding;
    PetListModel listModel;
    String currentLocation;

    private boolean isRefreshing;

    public static MainListFragment newInstance(){
        return new MainListFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        databindingSetup(container);
        return fragmentMainListBinding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerSetup();
        currentLocation = "27560"; //// TODO: 4/10/16 Allow changing of this in app
    }

    @Override
    public void onResume() {
        super.onResume();
        refresh(false);
    }

    @Override
    public void update() {
        if (fragmentMainListBinding != null && fragmentMainListBinding.swipeableRecyclerMain.recycler.getAdapter() != null) {
            fragmentMainListBinding.swipeableRecyclerMain.recycler.getAdapter().notifyDataSetChanged();
        }
    }


    private void refresh(boolean swipeRefresh){
        listModel.clearModels();
        if(!swipeRefresh){
            if(!isRefreshing){
                isRefreshing = true;
                petFind(0);
            }else{
                fragmentMainListBinding.swipeableRecyclerMain.refresh.setRefreshing(false);
            }
        }else{
            petFind(0);
        }
    }

    private void petFind(int page){
        int offset = page*Integer.parseInt(PetFinderApi.ConstantQueryParams.COUNT_VALUE);
        addSubscription(listModel.petFind(currentLocation, offset).subscribe(aBoolean -> {
            isRefreshing = false;
            fragmentMainListBinding.swipeableRecyclerMain.refresh.setRefreshing(false);
        }));
    }

    private void databindingSetup(ViewGroup container){
        fragmentMainListBinding = DataBindingUtil.inflate(LayoutInflater.from(getActivity()), getLayoutId(), container, false);
        listModel = new PetListModel(new CustomItemViewSelector<>(BR.viewModel));
        fragmentMainListBinding.setListModel(listModel);
        fragmentMainListBinding.executePendingBindings();
    }

    private void recyclerSetup(){
        fragmentMainListBinding.swipeableRecyclerMain.refresh.setOnRefreshListener(this);
        ((ListPaginatedAdapter) fragmentMainListBinding.swipeableRecyclerMain.recycler.getAdapter()).setPaginateAction(getPaginationAction());
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
