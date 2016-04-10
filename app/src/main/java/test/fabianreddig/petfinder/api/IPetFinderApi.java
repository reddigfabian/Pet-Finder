package test.fabianreddig.petfinder.api;

import rx.Observable;
import test.fabianreddig.petfinder.api.models.Petfinder;

/**
 * Created by WillowTree, Inc. on 4/2/16.
 */
public interface IPetFinderApi {

    Observable<Petfinder> petFind(String location, String lastOffset); // TODO: 4/9/16 Switch to single?

}
