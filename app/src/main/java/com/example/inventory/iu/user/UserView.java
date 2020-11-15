package com.example.inventory.iu.user;

import com.example.inventory.iu.base.BaseView;

public interface UserView extends BaseView {

    //Método que indica el usuario no puede ser nulo.
    void setUserEmptyError();

    //Método que indica que la contraseña no cumple el patrón indicado
    void setPasswordFormatError();

    //Método que indica la contraseña no puede ser nula
    void setPasswordEmptyError();
}
