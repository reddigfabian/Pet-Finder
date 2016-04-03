package test.fabianreddig.flickertestproject;

import android.app.Application;

import test.fabianreddig.flickertestproject.di.components.ApplicationComponent;
import test.fabianreddig.flickertestproject.di.components.DaggerApplicationComponent;
import test.fabianreddig.flickertestproject.di.modules.ApiModule;

/**
 * Created by WillowTree, Inc on 9/4/15.
 */
public class FlickrTestProjectApplication extends Application {
    private static FlickrTestProjectApplication app;
    private ApplicationComponent applicationComponent;

    public static ApplicationComponent applicationComponent() {
        return app.applicationComponent;
    }

    public static FlickrTestProjectApplication getApp() {
        return app;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        applicationComponent = DaggerApplicationComponent.builder()
                .apiModule(new ApiModule())
                .build();
    }
}
