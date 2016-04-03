package test.fabianreddig.flickertestproject.common.viewmodels;

import test.fabianreddig.flickertestproject.R;
import test.fabianreddig.flickertestproject.api.models.Photo;

/**
 * Created by WillowTree, Inc. on 4/3/16.
 */
public class PhotoListItemViewModel extends BaseViewModel {

    private Photo photo;

    public PhotoListItemViewModel(Photo photo){
        this.photo = photo;
    }

    public Photo getPhoto(){
        return photo;
    }

    @Override
    public int getLayoutID() {
        return R.layout.view_photo_list_item;
    }
}
