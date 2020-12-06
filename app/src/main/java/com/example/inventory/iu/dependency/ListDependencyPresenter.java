package com.example.inventory.iu.dependency;

import com.example.inventory.data.model.Dependency;

import java.util.List;

public class ListDependencyPresenter implements ListDependencyContract.Presenter, ListDependencyInteractorImpl.ListDependencyInteractor{

    private ListDependencyInteractorImpl interactor;
    private ListDependencyContract.view view;

    public ListDependencyPresenter(ListDependencyContract.view view) {
        this.interactor = new ListDependencyInteractorImpl(this);
        this.view = view;
    }
    /**
     * Este método viene de la interfaz del contrato con la vista
     */
    @Override
    public void load() {
        view.showProgress();
        interactor.load();
    }
    /**
     * Este método viene de la interfaz de BasePresenter
     */
    @Override
    public void onDestroy() {
        this.view = null;
        this.interactor = null;
    }

    /**
     * Este método viene de la interfaz de ListDependencyInteractor
     */
    @Override
    public void OnNoData() {
        view.hideProgress();
        this.view.setNoData();
    }
    /**
     * Este método viene de la interfaz de ListDependencyInteractor
     */
    @Override
    public void OnSuccess(List<Dependency> list) {
        view.hideProgress();
        this.view.onSuccess(list);
    }
}
