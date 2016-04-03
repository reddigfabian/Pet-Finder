package test.fabianreddig.flickertestproject;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import javax.inject.Inject;

import rx.Observer;
import test.fabianreddig.flickertestproject.api.IFlickerApi;
import test.fabianreddig.flickertestproject.api.models.FlickrGetRecentPhotos;
import test.fabianreddig.flickertestproject.databinding.ActivityMainBinding;
import test.fabianreddig.flickertestproject.util.RxUtil;

public class MainActivity extends AppCompatActivity {

    @Inject
    IFlickerApi flickerApi;

    ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FlickrTestProjectApplication.applicationComponent().inject(this);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        //Just testing out the API
        flickerApi.getRecentPhotos(1).compose(RxUtil.backgroundToMainThread()).subscribe(new Observer<FlickrGetRecentPhotos>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.e("MY_TAG", e.getMessage());
            }

            @Override
            public void onNext(FlickrGetRecentPhotos flickrGetRecentPhotos) {
                activityMainBinding.testText.setText(flickrGetRecentPhotos.getPhotos().getPhoto().get(0).getTitle());
            }
        });
    }

}
