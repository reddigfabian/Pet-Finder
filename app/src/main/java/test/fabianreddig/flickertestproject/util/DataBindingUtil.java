package test.fabianreddig.flickertestproject.util;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by WillowTree, Inc. on 4/3/16.
 */
public class DataBindingUtil {

    //Suppress default constructor for noninstantiability
    private DataBindingUtil(){
        throw new AssertionError();
    }

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView view, String URL) {
        Picasso.with(view.getContext())
                .load(URL)
                .noPlaceholder()
                .into(view);
    }
}
