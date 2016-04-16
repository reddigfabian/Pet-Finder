package test.fabianreddig.petfinder.util;

import android.databinding.BindingAdapter;
import android.support.v4.content.ContextCompat;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.List;

import test.fabianreddig.petfinder.R;
import test.fabianreddig.petfinder.api.models.Petfinder;

/**
 * Created by WillowTree, Inc. on 4/3/16.
 */
public class DataBinding {

    //Suppress default constructor for noninstantiability
    private DataBinding(){
        throw new AssertionError();
    }

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView view, List<HashMap<String, String>> images) {
        if(images.size()>0) {
            Picasso.with(view.getContext())
                    .load(images.get(0).get(Petfinder.SIZE_PN))
                    .error(ContextCompat.getDrawable(view.getContext(), R.drawable.error)) //TODO Better error img
                    .placeholder(ContextCompat.getDrawable(view.getContext(), R.drawable.place_holder)) //TODO Better placeholder
                    .into(view);
        }else{
            view.setImageResource(R.drawable.error); // TODO: 4/9/16 Set this to a "NO IMAGE AVAILABLE" placeholder
        }
    }
}