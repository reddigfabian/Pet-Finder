package test.fabianreddig.flickertestproject.util;

import android.databinding.BindingAdapter;
import android.support.v4.content.ContextCompat;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import test.fabianreddig.flickertestproject.R;
import test.fabianreddig.flickertestproject.api.models.Photo;

/**
 * Created by WillowTree, Inc. on 4/3/16.
 */
public class DataBindingUtil {

    //Suppress default constructor for noninstantiability
    private DataBindingUtil(){
        throw new AssertionError();
    }

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView view, Photo photo) {
        Picasso.with(view.getContext())
                .load(photo.getUrlC())
                .error(ContextCompat.getDrawable(view.getContext(), R.drawable.error))
                .placeholder(ContextCompat.getDrawable(view.getContext(), R.drawable.place_holder))
                .into(view);
    }
}
