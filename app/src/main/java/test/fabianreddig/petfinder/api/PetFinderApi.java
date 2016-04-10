package test.fabianreddig.petfinder.api;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import rx.Observable;
import test.fabianreddig.petfinder.BuildConfig;
import test.fabianreddig.petfinder.api.models.Petfinder;
import timber.log.Timber;

/**
 * Created by WillowTree, Inc. on 4/2/16.
 */
public class PetFinderApi implements IPetFinderApi {
    public static final String TAG = PetFinderApi.class.getName();

    public static final String PETFINDER_BASE_URL = "https://api.petfinder.com";

    private IPetFinderRetrofit petFinderRetrofit;

    public static class ConstantQueryParams {
        //keys
        public static final String API_KEY = "key";
        public static final String FORMAT = "format";
        public static final String COUNT = "count";
        public static final String[] CONSTANT_QUERY_PARAM_KEYS = new String[]{API_KEY, FORMAT, COUNT};

        //values
        public static final String API_KEY_VALUE = BuildConfig.PETFINDER_API_KEY;
        public static final String XML = "xml";
        public static final String COUNT_VALUE = "25";
        public static final String[] CONSTANT_QUERY_PARAM_VALUES = new String[]{API_KEY_VALUE, XML, COUNT_VALUE};

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
        public static final String LOCATION = "location";
        public static final String OFFSET = "offset";
        public static final String API_SIG = "sig";
    }

    public PetFinderApi(IPetFinderRetrofit iPetFinderRetrofit) {
        this.petFinderRetrofit = iPetFinderRetrofit;
    }

    @Override
    public Observable<Petfinder> petFind(String location, String lastOffset) {
        Map<String,String> params = new HashMap<>();
        params.putAll(ConstantQueryParams.constantQueryParams());
        params.put(VariableQueryParams.LOCATION, location);
        if(lastOffset!=null&&!lastOffset.equals("")) {
            params.put(VariableQueryParams.OFFSET, lastOffset);
        }
        return petFinderRetrofit.petFind(params);
    }

    private String generateSignature(Map<String, String> params){
        StringBuilder builder = new StringBuilder();
        builder.append(BuildConfig.PETFINDER_API_SECRET);
        for (String s : params.keySet()) {
            builder.append(s);
            builder.append("=");
            builder.append(params.get(s));
        }
        return MD5(builder.toString());
    }

    public String MD5(String md5) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] array = md.digest(md5.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte anArray : array) {
                sb.append(Integer.toHexString((anArray & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            Timber.e(e, TAG);
        }
        return null;
    }
}
