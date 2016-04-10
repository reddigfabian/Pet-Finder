package test.fabianreddig.petfinder.util;

import android.view.View;

import com.jakewharton.rxbinding.view.RxView;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Scheduler;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by WillowTree, Inc on 9/23/15.
 */
public class RxUtil {

    public static final int TIMEOUT = 500;

    public static <T> Observable.Transformer<T, T> backgroundToMainThread() {
        return observable -> observable.observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io());
    }

    public static <T> Observable.Transformer<T, T> backgroundThread() {
        Scheduler thread = Schedulers.io();
        return observable -> observable.subscribeOn(thread).observeOn(thread);
    }

    public static <T> Observable.Transformer<T, T> mainThread() {
        return observable -> observable.observeOn(AndroidSchedulers.mainThread()).subscribeOn(AndroidSchedulers.mainThread());
    }

    public static <T> Observable.Transformer<T, T> parallelableToMainThread() {
        return observable -> observable.observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.newThread());
    }

    public static Subscription debouncedOnClick(View view, Action1<Void> action) {
        return RxView.clicks(view)
                .debounce(TIMEOUT, TimeUnit.MILLISECONDS)
                .subscribe(action);
    }
}
