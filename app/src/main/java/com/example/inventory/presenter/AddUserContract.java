package com.example.inventory.presenter;

public interface AddUserContract {
    interface View extends UserView{
        //Ya existe el usuario
        void emailDuplicated();
    }

    interface Presenter{
        //Valida el usuario a la base de datos desde Registro
        void addUser(String user, String password, String email);
    }
}
