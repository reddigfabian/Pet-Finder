package test.fabianreddig.petfinder.mainactivity.viewmodels;

import javax.inject.Inject;

import me.tatarka.bindingcollectionadapter.BaseItemViewSelector;
import rx.Observer;
import rx.Single;
import rx.SingleSubscriber;
import test.fabianreddig.petfinder.PetFinderApplication;
import test.fabianreddig.petfinder.api.IPetFinderApi;
import test.fabianreddig.petfinder.api.models.Petfinder;
import test.fabianreddig.petfinder.common.viewmodels.ListModel;
import test.fabianreddig.petfinder.util.RxUtil;

/**
 * Created by WillowTree, Inc. on 4/9/16.
 */
public class PetListModel extends ListModel<MainListItemViewModel> {

    @Inject
    IPetFinderApi petFinderApi;

    public PetListModel(BaseItemViewSelector<MainListItemViewModel> selector) {
        super(selector);
        PetFinderApplication.applicationComponent().inject(this);
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
                            throw new IllegalStateException("Unable to find any pets."); //Todo handle this case better
                        }else {
                            for (Petfinder.Pet pet : petfinder.getPets()) {
                                addModel(new MainListItemViewModel(pet));
                            }
                        }
                    }
                });
            }
        }).compose(RxUtil.singleMainThread());

    }
}
