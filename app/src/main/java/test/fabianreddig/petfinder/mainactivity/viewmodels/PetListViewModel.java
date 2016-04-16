package test.fabianreddig.petfinder.mainactivity.viewmodels;

import javax.inject.Inject;

import me.tatarka.bindingcollectionadapter.BR;
import rx.Observer;
import rx.Single;
import rx.SingleSubscriber;
import test.fabianreddig.petfinder.PetFinderApplication;
import test.fabianreddig.petfinder.api.IPetFinderApi;
import test.fabianreddig.petfinder.api.models.Petfinder;
import test.fabianreddig.petfinder.common.CustomItemViewSelector;
import test.fabianreddig.petfinder.common.viewmodels.ListModel;
import test.fabianreddig.petfinder.util.RxUtil;

/**
 * Created by WillowTree, Inc. on 4/9/16.
 */
public class PetListViewModel{

    public static final String TAG = PetListViewModel.class.getName();

    @Inject
    IPetFinderApi petFinderApi;

    ListModel<MainListItemViewModel> listModel;
    boolean wasPaged;
    int currentPosition;

    public PetListViewModel() {
        PetFinderApplication.applicationComponent().inject(this);
        listModel = new ListModel<>(new CustomItemViewSelector<>(BR.viewModel));
        currentPosition = 0;
    }

    public Single<Boolean> petFind(String location, int offset){
        return Single.create(new Single.OnSubscribe<Boolean>() {
            @Override
            public void call(SingleSubscriber<? super Boolean> singleSubscriber) {
                petFinderApi.petFind(location, String.valueOf(offset)).compose(RxUtil.observableBackgroundToMainThread()).subscribe(new Observer<Petfinder>() {
                    @Override
                    public void onCompleted() {
                        singleSubscriber.onSuccess(true);
                    }

                    @Override
                    public void onError(Throwable e) {
                        singleSubscriber.onError(e);
                    }

                    @Override
                    public void onNext(Petfinder petfinder) {
                        if(petfinder.getPets()==null){
                            throw new IllegalStateException("Unable to find any pets."); //Todo handle this case better; add empty state
                        }else {
                            for (int i = 0; i < petfinder.getPets().size(); i++) {
                                listModel.addModel(new MainListItemViewModel(petfinder.getPets().get(i), i+offset));
                            }
                        }
                    }
                });
            }
        }).compose(RxUtil.singleMainThread());
    }

    public void clearList(){
        listModel.clearModels();
    }

    public ListModel<MainListItemViewModel> getListModel() {
        return listModel;
    }

    public void setListModel(ListModel<MainListItemViewModel> listModel) {
        this.listModel = listModel;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public boolean isWasPaged() {
        return wasPaged;
    }

    public void setWasPaged(boolean wasPaged) {
        this.wasPaged = wasPaged;
    }

    public int getPetCount() {
        return listModel.getModels().size();
    }
}
