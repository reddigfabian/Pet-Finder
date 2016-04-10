package test.fabianreddig.petfinder;

import android.app.Application;

import test.fabianreddig.petfinder.di.components.ApplicationComponent;
import test.fabianreddig.petfinder.di.components.DaggerApplicationComponent;
import test.fabianreddig.petfinder.di.modules.ApiModule;

/**
 * Created by WillowTree, Inc on 9/4/15.
 */
public class PetFinderApplication extends Application {
    private static PetFinderApplication app;
    private ApplicationComponent applicationComponent;

    public static ApplicationComponent applicationComponent() {
        return app.applicationComponent;
    }

    public static PetFinderApplication getApp() {
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
