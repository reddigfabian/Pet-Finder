package test.fabianreddig.petfinder.di.components;

import javax.inject.Singleton;

import dagger.Component;
import test.fabianreddig.petfinder.mainactivity.MainActivity;
import test.fabianreddig.petfinder.di.modules.ApiModule;

/**
 * Created by WillowTree, Inc. on 3/31/16.
 */
@Singleton
@Component(modules = {ApiModule.class})
public interface ApplicationComponent {

    void inject(MainActivity activity);

}
