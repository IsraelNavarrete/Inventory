package com.example.inventory.iu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.inventory.R;
import com.example.inventory.presenter.AddUserContract;
import com.example.inventory.presenter.UserPresenter;
import com.google.android.material.textfield.TextInputEditText;

public class SingUpActivity extends AppCompatActivity implements AddUserContract.View {

    private String user;
    private String password;
    private String email;
    private AddUserContract.Presenter presenter;
    private String confirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);

        //Recogemos el nombre del usuario
        TextInputEditText tieUser = findViewById(R.id.tieUser);
        user=tieUser.getText().toString();

        //Recogemos la primera contraseña
        TextInputEditText tiePassword = findViewById(R.id.tiePassword);
        password = tiePassword.getText().toString();

        //Recogemos la contraseña de confirmacion
        TextInputEditText tieConfirmPasword = findViewById(R.id.tieConfirmPassword);
        confirmPassword = tieConfirmPasword.getText().toString();

        //Recogemos email
        TextInputEditText tieEmail = findViewById(R.id.tieEmail);
        email = tieEmail.getText().toString();

        presenter = new UserPresenter(this);
    }

    /**
     * Metodo que comprueba si es valido el usuario, la contraseña y el email
     */
    public void signUp(){
        //1. Comprobar las reglas de negocio del nombre
        if (validateUser(user) && validatePassword(password,confirmPassword) && validateEmail(email)) {
            presenter.addUser(user, password, email);
            onSuccess();
        }
    }


    /**
     * Validar que el nombre de usuario es correcto
     * @param user
     * @return
     */
    private boolean validateUser(String user) {
        return true;
    }

    /**
     * Validar que ambas contraseñas cumplen los requisitos funcionales
     * @param password
     * @param confirmPassword
     * @return
     */
    private boolean validatePassword(String password, String confirmPassword) {
        return true;
    }

    /**
     * Validar que el email cumple los requisitos funcionales
     * @param email
     * @return
     */
    private boolean validateEmail(String email) {
        return true;
    }

    /**
     * Comprobar que el usuario no existe (SQLite, XML, MySQL...)
     */
    @Override
    public void emailDuplicated() {

    }

    /**
     * Se da de alta el usuario y pasamos a la pantalla Login
     */
    @Override
    public void onSuccess() {
        Intent intent = new Intent( SingUpActivity.this, InventoryActivity.class);
        startActivity(intent);
    }
}