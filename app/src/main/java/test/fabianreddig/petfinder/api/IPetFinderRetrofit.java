package test.fabianreddig.petfinder.api;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rx.Observable;
import test.fabianreddig.petfinder.api.models.Petfinder;

/**
 * Created by WillowTree, Inc. on 3/31/16.
 */
public interface IPetFinderRetrofit {

    @GET("pet.find")
    Observable<Petfinder> petFind(@QueryMap Map<String, String> params); // TODO: 4/9/16 Switch to Single?
}
