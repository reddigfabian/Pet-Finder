package test.fabianreddig.flickertestproject.api;

import android.util.Log;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

import rx.Observable;
import test.fabianreddig.flickertestproject.BuildConfig;
import test.fabianreddig.flickertestproject.api.models.FlickrPhotoResponse;

/**
 * Created by WillowTree, Inc. on 4/2/16.
 */
public class FlickrApi implements IFlickerApi {

    public static final String FLICKR_BASE_URL = "https://api.flickr.com/services/";
    public static final String GET_RECENT_PHOTOS_EXTRAS = "original_format,o_dims,url_q,url_n,url_c,url_h,url_o";
    public static final int PER_PAGE = 20;

    private IFlickerRetrofit flickrRetrofit;

    public static class ConstantQueryParams {
        //keys
        public static final String API_KEY = "api_key";
        public static final String FORMAT = "format";
        public static final String NO_JSON_CALLBACK = "nojsoncallback";
        public static final String[] CONSTANT_QUERY_PARAM_KEYS = new String[]{API_KEY, FORMAT, NO_JSON_CALLBACK};

        //values
        public static String apiKey = BuildConfig.FLICKR_CONSUMER_KEY;
        public static String format = "json";
        public static String noJsonCallback = "1";
        public static final String[] CONSTANT_QUERY_PARAM_VALUES = new String[]{apiKey, format, noJsonCallback};

        private static HashMap<String, String> constantQueryParams(){
            HashMap<String, String> constantQueryParams = new HashMap<>();
            for (int i = 0; i < CONSTANT_QUERY_PARAM_KEYS.length; i++) {
                constantQueryParams.put(CONSTANT_QUERY_PARAM_KEYS[i], CONSTANT_QUERY_PARAM_VALUES[i]);
            }
            return constantQueryParams;
        }
    }

    public static class VariableQueryParams {
        //keys
        public static final String EXTRAS = "extras";
        public static final String API_SIG = "api_sig";
        public static final String PAGE = "page";
        public static final String PER_PAGE = "per_page";
        public static final String TEXT = "text";

        public static final String[] VARIABLE_QUERY_PARAM_KEYS = new String[]{EXTRAS, API_SIG, PAGE, PER_PAGE, TEXT};
    }

    public FlickrApi(IFlickerRetrofit iFlickerRetrofit) {
        this.flickrRetrofit = iFlickerRetrofit;
    }

    @Override
    public Observable<FlickrPhotoResponse> getRecentPhotos(int page) {
        HashMap<String, String> variableQueryParams = new HashMap<>();
        variableQueryParams.put(VariableQueryParams.EXTRAS, GET_RECENT_PHOTOS_EXTRAS);
        variableQueryParams.put(VariableQueryParams.PAGE, page+"");
        variableQueryParams.put(VariableQueryParams.PER_PAGE, PER_PAGE+"");
        String encodedExtras = "";
        try {
            encodedExtras = URLEncoder.encode(GET_RECENT_PHOTOS_EXTRAS, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return flickrRetrofit.getRecentPhotos(ConstantQueryParams.apiKey,
                                              ConstantQueryParams.format,
                                              ConstantQueryParams.noJsonCallback,
                                              encodedExtras,
//                                              generateApiSig(ConstantQueryParams.constantQueryParams(), variableQueryParams, GET_RECENT_PHOTOS_EXTRAS),
                                              page,
                                              PER_PAGE);
    }

    @Override
    public Observable<FlickrPhotoResponse> photosSearch(int page, String searchText) {
        HashMap<String, String> variableQueryParams = new HashMap<>();
        variableQueryParams.put(VariableQueryParams.EXTRAS, GET_RECENT_PHOTOS_EXTRAS);
        variableQueryParams.put(VariableQueryParams.PAGE, page+"");
        variableQueryParams.put(VariableQueryParams.PER_PAGE, PER_PAGE+"");
        variableQueryParams.put(VariableQueryParams.TEXT, searchText);
        String encodedExtras = "";
        try {
            encodedExtras = URLEncoder.encode(GET_RECENT_PHOTOS_EXTRAS, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return flickrRetrofit.photosSearch(ConstantQueryParams.apiKey,
                ConstantQueryParams.format,
                ConstantQueryParams.noJsonCallback,
                encodedExtras,
//                                              generateApiSig(ConstantQueryParams.constantQueryParams(), variableQueryParams, GET_RECENT_PHOTOS_EXTRAS),
                page,
                PER_PAGE,
                searchText);
    }

    private String generateApiSig(HashMap<String, String> constantQueryParams, HashMap<String, String> variableQueryParams, String extras){
        StringBuilder sigBuilder = new StringBuilder();
        sigBuilder.append(BuildConfig.FLICKR_CONSUMER_SECRET);
        Iterator<String> constantIterator = constantQueryParams.keySet().iterator();
        Iterator<String> variableIterator = variableQueryParams.keySet().iterator();
        String[] keys = new String[constantQueryParams.size() + variableQueryParams.size()+1];
        int itr = 1;
        keys[0] = VariableQueryParams.EXTRAS;
        while(constantIterator.hasNext()){
            keys[itr] = constantIterator.next();
            itr++;
        }
        while(variableIterator.hasNext()){
            keys[itr] = variableIterator.next();
            itr++;
        }
        Arrays.sort(keys);
        for (String key : keys) {
            sigBuilder.append(key);
            if(key.equals(VariableQueryParams.EXTRAS)){
                sigBuilder.append(extras);
            }else if(variableQueryParams.containsKey(key)){
                sigBuilder.append(variableQueryParams.get(key));
            }else if(constantQueryParams.containsKey(key)){
                sigBuilder.append(variableQueryParams.get(key));
            }
        }
        Log.i("pre-md5", sigBuilder.toString());
        return md5(sigBuilder.toString());
    }

    private String md5(String toHash){
        String toReturn = "";
        try {
            byte[] bytesOfMessage = toHash.getBytes("UTF-8");
            MessageDigest md;
            md = MessageDigest.getInstance("MD5");
            byte[] thedigest = md.digest(bytesOfMessage);
            toReturn = new String(thedigest);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Log.i("md5", toReturn);
        return toReturn;
    }
}
