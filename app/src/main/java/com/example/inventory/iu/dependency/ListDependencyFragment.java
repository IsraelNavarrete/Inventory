package com.example.inventory.iu.dependency;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.inventory.R;
import com.example.inventory.data.model.Dependency;
import com.example.inventory.iu.adapter.DependencyAdapter;

import java.util.List;

public class ListDependencyFragment extends Fragment implements ListDependencyContract.view{

private LinearLayout llLoading;
private LinearLayout llNoData;
private RecyclerView rvDependency;
private DependencyAdapter adapter;
private ListDependencyContract.Presenter presenter;
    public ListDependencyFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_dependency, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        llLoading=view.findViewById(R.id.llLoading);
        llNoData=view.findViewById(R.id.llNoData);
        rvDependency=view.findViewById(R.id.rvDependency);
        //1. Crear adapter
        adapter= new DependencyAdapter(null);
        //2. Crear el diseño del recyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
        //3. Se asigna el diseño al RecyclerView
        rvDependency.setLayoutManager(layoutManager);
        //4. Vincular la vista al modelo
        rvDependency.setAdapter(adapter);

        //Se inicializa el presenter
        presenter = new ListDependencyPresenter(this);
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.load();
    }

    @Override
    public void showProgress() {
        llLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        llLoading.setVisibility(View.GONE);
    }

    @Override
    public void setNoData() {
        llNoData.setVisibility(View.VISIBLE);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //presenter.onDestroy();
    }

    @Override
    public void onSuccess(List<Dependency> list) {
        //1. Si está visible NODATA cambia la visibilidad a GONE
        if (llNoData.getVisibility()==View.VISIBLE)
            llNoData.setVisibility(View.GONE);
        //2. Se cargas los datos del recycler
        adapter.update(list);
    }
}