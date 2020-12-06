package com.example.inventory.data.repository;

import com.example.inventory.data.model.Dependency;

import java.util.ArrayList;
import java.util.List;

public class DependencyRepository {
    private List<Dependency> list;
    private static DependencyRepository repository;

    private DependencyRepository(){
        this.list= new ArrayList<>();
        initialice();
    }

    private void initialice(){
        list.add(new Dependency("2 ciclo formativo DAM","2DAM",
                "aula",""));
        list.add(new Dependency("1 ciclo formativo DAM","1DAM",
                "aula",""));
        list.add(new Dependency("2 ciclo formativo SMR","2SMR",
                "aula",""));
        list.add(new Dependency("1 ciclo formativo SMR","1SMR",
                "aula",""));
    }
    public static DependencyRepository getInstance(){
        return repository;
    }
    public List<Dependency> getList(){
        return list;
    }


}
