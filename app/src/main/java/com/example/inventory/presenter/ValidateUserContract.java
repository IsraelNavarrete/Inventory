package com.example.inventory.presenter;

public interface ValidateUserContract {
    interface View extends UserView{
        //La contraseña es erronea
        void PasswordError();

        //El email no existe
        void emailError();

    }

    interface Presenter{
        //Valida el usuario de la pantalla Login
        void validateUser(String email,String password);
    }
}
