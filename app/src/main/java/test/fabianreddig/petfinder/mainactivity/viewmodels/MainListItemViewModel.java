package test.fabianreddig.petfinder.mainactivity.viewmodels;

import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import test.fabianreddig.petfinder.PetFinderApplication;
import test.fabianreddig.petfinder.R;
import test.fabianreddig.petfinder.api.models.Petfinder;
import test.fabianreddig.petfinder.common.viewmodels.BaseViewModel;

/**
 * Created by WillowTree, Inc. on 4/9/16.
 */
public class MainListItemViewModel extends BaseViewModel{
    public static final String ON_PET_CLICKED = "on_pet_clicked";
    public static final String EXTRA_POSITION = "extra_position";

    private Petfinder.Pet pet;
    private int position;

    @Inject
    LocalBroadcastManager broadcastManager;

    public MainListItemViewModel(Petfinder.Pet pet, int position){
        PetFinderApplication.applicationComponent().inject(this);
        this.pet = pet;
        this.position = position;
        configureImageMap();
    }

    public void onPetClicked(View v){
        Intent petClickIntent = new Intent(ON_PET_CLICKED);
        petClickIntent.putExtra(EXTRA_POSITION, position);
        broadcastManager.sendBroadcast(petClickIntent);
    }

    private void configureImageMap(){
        List<HashMap<String,String>> newImages = new ArrayList<>();
        List<Petfinder.Photo> photos = pet.getMedia().getPhotos();
        if(photos!=null) {
            for (int i = 0; i < (photos.size() / Petfinder.SIZES_PER_IMG); i++) {
                newImages.add(new HashMap<>());
            }
            for (int i = 0; i < photos.size(); i++) {
                Petfinder.Photo currentPhoto = photos.get(i);
                int currentID = Integer.parseInt(currentPhoto.getId());
                HashMap<String, String> currentMap = newImages.get(currentID - 1);
                currentMap.put(currentPhoto.getSize(), currentPhoto.getUrl());
            }
            pet.setImages(newImages);
        }
    }

    public Petfinder.Pet getPet() {
        return pet;
    }

    public void setPet(Petfinder.Pet pet) {
        this.pet = pet;
    }

    public int getPosition() {
        return position;
    }

    public String getPositionStr(){
        return position+"";
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public int getLayoutID() {
        return R.layout.view_main_list_item;
    }
}
