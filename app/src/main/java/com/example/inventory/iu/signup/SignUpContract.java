package com.example.inventory.iu.signup;

import com.example.inventory.iu.base.BasePresenter;
import com.example.inventory.iu.user.UserView;

public interface SignUpContract{
    interface View extends UserView {
        //Método que viene de la alternativa 1.3 Contraseñas diferentes
        void showProgressDialog();

        //Ocultazr el cuadro de dialogo
        void hideProgressDialog();

        //Método que viene de la alternativa 1.3 Contraseñas diferentes
        void setPasswordsNotEqualError();

        //Metodo que viene de la alternativa 1.4 Usuario ya existe
        void setUserAlreadyExists();

        //Metodo que viene de RN: el email tiene que tener un formato correcto
        void setEmailEmptyError();

        //El email debe cumplir un formato correcto
        void setEmailFormatError();
    }

    interface Presenter extends BasePresenter{
        void validateUser(String user, String password, String confirmPassword, String email);
    }
}
