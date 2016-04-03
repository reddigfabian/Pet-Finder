package test.fabianreddig.flickertestproject.api;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;
import test.fabianreddig.flickertestproject.api.models.FlickrGetRecentPhotos;

/**
 * Created by WillowTree, Inc. on 3/31/16.
 */
public interface IFlickerRetrofit {

    @GET("rest/?method=flickr.photos.getRecent")
    Observable<FlickrGetRecentPhotos> getRecentPhotos(@Query(FlickrApi.ConstantQueryParams.API_KEY) String apiKey,
                                                      @Query(FlickrApi.ConstantQueryParams.FORMAT) String format,
                                                      @Query(FlickrApi.ConstantQueryParams.NO_JSON_CALLBACK) String noJsonCallback,
                                                      @Query(value = FlickrApi.VariableQueryParams.EXTRAS, encoded = true) String extras,
//                                                      @Query(FlickrApi.VariableQueryParams.API_SIG) String apiSig,
                                                      @Query(FlickrApi.VariableQueryParams.PAGE) int page,
                                                      @Query(FlickrApi.VariableQueryParams.PER_PAGE) int perPage);

}
