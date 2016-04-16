package test.fabianreddig.petfinder.di.modules;

import android.support.v4.content.LocalBroadcastManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import test.fabianreddig.petfinder.PetFinderApplication;

/**
 * Created by WillowTree, Inc. on 4/14/16.
 */
@Module
public class AppModule {
    @Provides
    @Singleton
    public LocalBroadcastManager providesLocalBroadcastManager(){
        return LocalBroadcastManager.getInstance(PetFinderApplication.getApp());
    }
}
