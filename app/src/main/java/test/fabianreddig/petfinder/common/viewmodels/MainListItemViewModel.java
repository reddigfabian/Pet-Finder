package test.fabianreddig.petfinder.common.viewmodels;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import test.fabianreddig.petfinder.R;
import test.fabianreddig.petfinder.api.models.Petfinder;

/**
 * Created by WillowTree, Inc. on 4/9/16.
 */
public class MainListItemViewModel extends BaseViewModel {
    public Petfinder.Pet pet;

    public MainListItemViewModel(Petfinder.Pet pet){
        this.pet = pet;
        configureImageMap();
    }

    private void configureImageMap(){
        List<HashMap<String,String>> newImages = new ArrayList<>();
        List<Petfinder.Photo> photos = pet.getMedia().getPhotos();
        for (int i = 0; i < photos.size(); i++) {
            Petfinder.Photo currentPhoto = photos.get(i);
            int currentID = Integer.parseInt(currentPhoto.getId());
            HashMap<String, String> currentMap = newImages.get(currentID);
            if(currentMap==null){
                newImages.add(currentID, new HashMap<>());
                currentMap = newImages.get(currentID);
            }
            currentMap.put(currentPhoto.getSize(), currentPhoto.getUrl());
        }
        pet.setImages(newImages);
    }

    public Petfinder.Pet getPet() {
        return pet;
    }

    public void setPet(Petfinder.Pet pet) {
        this.pet = pet;
    }

    @Override
    public int getLayoutID() {
        return R.layout.view_main_list_item;
    }
}
