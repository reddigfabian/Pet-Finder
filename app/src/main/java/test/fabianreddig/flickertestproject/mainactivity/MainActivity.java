package test.fabianreddig.flickertestproject.mainactivity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import me.tatarka.bindingcollectionadapter.BR;
import rx.Observer;
import test.fabianreddig.flickertestproject.FlickrTestProjectApplication;
import test.fabianreddig.flickertestproject.R;
import test.fabianreddig.flickertestproject.api.IFlickerApi;
import test.fabianreddig.flickertestproject.api.models.FlickrGetRecentPhotos;
import test.fabianreddig.flickertestproject.api.models.Photo;
import test.fabianreddig.flickertestproject.common.CustomItemViewSelector;
import test.fabianreddig.flickertestproject.common.viewmodels.ListModel;
import test.fabianreddig.flickertestproject.common.viewmodels.PhotoListItemViewModel;
import test.fabianreddig.flickertestproject.databinding.ActivityMainBinding;
import test.fabianreddig.flickertestproject.util.RxUtil;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();

    @Inject
    IFlickerApi flickerApi;

    ActivityMainBinding activityMainBinding;
    private ListModel<PhotoListItemViewModel> listModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FlickrTestProjectApplication.applicationComponent().inject(this);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        listModel = new ListModel<>(new CustomItemViewSelector<>(BR.photoListItem));
        activityMainBinding.setListModel(listModel);
        activityMainBinding.executePendingBindings();

    }

    @Override
    protected void onResume() {
        super.onResume();
        //Just testing out the API
        flickerApi.getRecentPhotos(1).compose(RxUtil.backgroundToMainThread()).subscribe(new Observer<FlickrGetRecentPhotos>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Timber.e(e.getMessage(), TAG);
            }

            @Override
            public void onNext(FlickrGetRecentPhotos flickrGetRecentPhotos) {
                List<PhotoListItemViewModel> newModels = new ArrayList<>();
                for (Photo photo : flickrGetRecentPhotos.getPhotos().getPhoto()) {
                    newModels.add(new PhotoListItemViewModel(photo));
                }
                listModel.addModels(newModels);
            }
        });
    }
}
