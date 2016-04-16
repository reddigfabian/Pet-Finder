package test.fabianreddig.petfinder.di.components;

import javax.inject.Singleton;

import dagger.Component;
import test.fabianreddig.petfinder.di.modules.ApiModule;
import test.fabianreddig.petfinder.di.modules.AppModule;
import test.fabianreddig.petfinder.mainactivity.MainActivity;
import test.fabianreddig.petfinder.mainactivity.MainListFragment;
import test.fabianreddig.petfinder.mainactivity.viewmodels.MainListItemViewModel;
import test.fabianreddig.petfinder.mainactivity.viewmodels.PetListViewModel;

/**
 * Created by WillowTree, Inc. on 3/31/16.
 */
@Singleton
@Component(modules = {ApiModule.class, AppModule.class})
public interface ApplicationComponent {

    void inject(MainActivity mainActivity);

    void inject(MainListFragment mainListFragment);

    void inject(PetListViewModel petListViewModel);

    void inject(MainListItemViewModel mainListItemViewModel);
}
