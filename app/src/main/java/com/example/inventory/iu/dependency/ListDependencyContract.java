package com.example.inventory.iu.dependency;

import com.example.inventory.data.model.Dependency;
import com.example.inventory.iu.base.BasePresenter;
import com.example.inventory.iu.base.BaseListView;

public class ListDependencyContract {
    interface view extends BaseListView<Dependency> {

        void showProgress();

        void hideProgress();

        //Activa la parte de la vista que indica que no hay datos
        void setNoData();

    }

    interface Presenter extends BasePresenter{
        void load();
    }
}
