package test.fabianreddig.petfinder.di.modules;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;
import test.fabianreddig.petfinder.BuildConfig;
import test.fabianreddig.petfinder.api.IPetFinderApi;
import test.fabianreddig.petfinder.api.IPetFinderRetrofit;
import test.fabianreddig.petfinder.api.PetFinderApi;

/**
 * Created by WillowTree, Inc. on 3/31/16.
 */
@Module
public class ApiModule {

    @Provides
    @Singleton
    public IPetFinderApi providesPetFinderApi(IPetFinderRetrofit petFinderRetrofit){
        return new PetFinderApi(petFinderRetrofit);
    }

    @Provides
    @Singleton
    public IPetFinderRetrofit providesPetFinderRetrofit(Retrofit retrofit){
        return retrofit.create(IPetFinderRetrofit.class);
    }

    @Provides
    @Singleton
    public Retrofit providesRetrofit() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder()
                                                    .readTimeout(3, TimeUnit.MINUTES)
                                                    .writeTimeout(3, TimeUnit.MINUTES);
        if(BuildConfig.DEBUG){
            clientBuilder.interceptors().add(interceptor);
            clientBuilder.connectTimeout(3, TimeUnit.MINUTES);
        }
        OkHttpClient client = clientBuilder.build();
        return new Retrofit.Builder()
                .baseUrl(PetFinderApi.PETFINDER_BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .client(client)
                .build();
    }
}