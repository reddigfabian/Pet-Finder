package test.fabianreddig.flickertestproject.di.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import test.fabianreddig.flickertestproject.api.IFlickerApi;
import test.fabianreddig.flickertestproject.api.IFlickerRetrofit;
import test.fabianreddig.flickertestproject.api.FlickrApi;

/**
 * Created by WillowTree, Inc. on 3/31/16.
 */
@Module
public class ApiModule {

    @Provides
    @Singleton
    public IFlickerApi providesFlickerApi(IFlickerRetrofit flickerRetrofit){
        return new FlickrApi(flickerRetrofit);
    }

    @Provides
    @Singleton
    public IFlickerRetrofit providesFlickerRetrofit(Retrofit retrofit){
        return retrofit.create(IFlickerRetrofit.class);
    }

    @Provides
    @Singleton
    public Retrofit providesRetrofit() {
        OkHttpClient client = new OkHttpClient();
//        if (BuildConfig.DEBUG) // TODO: 4/1/16 Configure this for this project
//            client.setConnectTimeout(3, TimeUnit.MINUTES);
//        client.setReadTimeout(3, TimeUnit.MINUTES);
//        client.setWriteTimeout(3, TimeUnit.MINUTES);
        return new Retrofit.Builder()
                .baseUrl(FlickrApi.FLICKR_BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }
}