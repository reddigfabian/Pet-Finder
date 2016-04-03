package test.fabianreddig.flickertestproject.common;

import me.tatarka.bindingcollectionadapter.BR;
import me.tatarka.bindingcollectionadapter.BaseItemViewSelector;
import me.tatarka.bindingcollectionadapter.ItemView;
import test.fabianreddig.flickertestproject.common.viewmodels.BaseViewModel;

/**
 * Created by WillowTree, Inc. on 4/3/16.
 */
public class CustomItemViewSelector<T extends BaseViewModel> extends BaseItemViewSelector<T> {
    @Override
    public void select(ItemView itemView, int position, T item) {
        itemView.setBindingVariable(BR.photoListItem).setLayoutRes(item.getLayoutID());
    }
}
