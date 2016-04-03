package test.fabianreddig.flickertestproject.di.components;

import javax.inject.Singleton;

import dagger.Component;
import test.fabianreddig.flickertestproject.mainactivity.MainActivity;
import test.fabianreddig.flickertestproject.di.modules.ApiModule;

/**
 * Created by WillowTree, Inc. on 3/31/16.
 */
@Singleton
@Component(modules = {ApiModule.class})
public interface ApplicationComponent {

    void inject(MainActivity activity);

}
