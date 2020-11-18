package com.example.inventory.iu.signup;

import android.os.Handler;
import android.text.TextUtils;

import com.example.inventory.data.repository.UserRepository;
import com.example.inventory.iu.login.LoginInteractorImpl;
import com.example.inventory.iu.utils.CommonUtils;

public class SignUpInteractorImpl {

    private SignUpInteractor presenter;

    interface SignUpInteractor {
        void onUserEmptyError(); //RN-U1 y Alternativa 1.1

        void onPasswordEmptyError(); //RN-U1 y Alternativa 1.1

        void onPasswordFormatError(); //RN-U2 y Alternativa 1.2

        void onAuthenticationError(); //Alternativa 1.3

        //Método que viene de la alternativa 1.3 Contraseñas diferentes
        void showProgressDialog();

        //Ocultazr el cuadro de dialogo
        void hideProgressDialog();

        //Método que viene de la alternativa 1.3 Contraseñas diferentes
        void onPasswordsNotEqualError();

        //Metodo que viene de la alternativa 1.4 Usuario ya existe
        void onUserAlreadyExists();

        //Metodo que viene de RN: el email tiene que tener un formato correcto
        void onEmailEmptyError();

        //El email debe cumplir un formato correcto
        void onEmailFormatError();

        void onSuccess(); //Secuencia normal del caso de uso.
    }

    /**
     * Este método contiene la lógica empresarial del caso de uso UC1-Login
     * Se crea un hilo para simular el retardo de dos segundos y ver cómo en la
     * vista se visualiza una barra de progreso.
     *
     * @param user
     * @param password
     */
    public void validateUser(final String user, final String password, final String confirmPassword, final String email) {
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                //Reglas de negocio y  Alternativas del caso de uso UC1-Login
                //RN-U1 y Alternativa 1.1.: el usuario no puede ser nulo
                if (TextUtils.isEmpty(user)) {
                    presenter.onUserEmptyError();
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    presenter.onPasswordEmptyError();
                    return;
                }
                if (!CommonUtils.isPasswordValid(password))
                {
                    presenter.onPasswordFormatError();
                    return;
                }
                if(!UserRepository.getInstance().validateCredentials(user,password)){
                    presenter.onAuthenticationError();
                    return;
                }
                if(!confirmPassword.equals(password))
                {
                    presenter.onPasswordsNotEqualError();
                }
                if(TextUtils.isEmpty(email))
                {
                    presenter.onEmailEmptyError();
                    return;
                }
                if(!CommonUtils.isEmailValid(email))
                {
                    presenter.onEmailFormatError();
                    return;
                }
                if(UserRepository.getInstance().userExists(user))
                {
                    presenter.onUserAlreadyExists();
                    return;
                }
                //Caso de éxito
                UserRepository.getInstance().add(user,password,email);
                presenter.onSuccess();
            }
        }, 2000);
    }

    public SignUpInteractorImpl(SignUpInteractorImpl.SignUpInteractor presenter) {
        this.presenter=presenter;
    }
}

