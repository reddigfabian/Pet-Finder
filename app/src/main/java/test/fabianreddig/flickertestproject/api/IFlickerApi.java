package test.fabianreddig.flickertestproject.api;

import rx.Observable;
import test.fabianreddig.flickertestproject.api.models.FlickrPhotoResponse;

/**
 * Created by WillowTree, Inc. on 4/2/16.
 */
public interface IFlickerApi {

    Observable<FlickrPhotoResponse> getRecentPhotos(int page);

    Observable<FlickrPhotoResponse> photosSearch(int page, String searchText);
}
