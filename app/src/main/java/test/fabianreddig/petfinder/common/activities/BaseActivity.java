package test.fabianreddig.petfinder.common.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by WillowTree, Inc. on 4/10/16.
 */
public class BaseActivity extends AppCompatActivity {
    private CompositeSubscription subscription;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        subscription = new CompositeSubscription();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        subscription.unsubscribe();
    }

    public void addSubscription(Subscription subscription) {
        this.subscription.add(subscription);
    }

    @Override
    public void setTitle(CharSequence title) {
        if(getSupportActionBar()!=null)getSupportActionBar().setTitle(title);
    }

    @Override
    public void setTitle(int titleId) {
        if(getSupportActionBar()!=null)getSupportActionBar().setTitle(titleId);
    }
}
