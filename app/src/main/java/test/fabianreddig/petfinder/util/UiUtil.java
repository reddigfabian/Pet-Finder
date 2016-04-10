package test.fabianreddig.petfinder.util;

import android.content.Context;
import android.util.TypedValue;

/**
 * Created by WillowTree, Inc. on 4/3/16.
 */
public class UiUtil {

    //Suppress default constructor for noninstantiability
    private UiUtil(){
        throw new AssertionError();
    }

    public static int dpToPx(Context context, int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.getResources().getDisplayMetrics());
    }

}
