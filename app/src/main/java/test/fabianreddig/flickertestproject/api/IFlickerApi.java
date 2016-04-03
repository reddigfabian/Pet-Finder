package test.fabianreddig.flickertestproject.api;

import rx.Observable;
import test.fabianreddig.flickertestproject.api.models.FlickrGetRecentPhotos;

/**
 * Created by WillowTree, Inc. on 4/2/16.
 */
public interface IFlickerApi {

    Observable<FlickrGetRecentPhotos> getRecentPhotos(int page);
}
