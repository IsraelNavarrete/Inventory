package com.example.inventory.iu.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.inventory.R;
import com.example.inventory.iu.InventoryActivity;
import com.example.inventory.iu.login.LoginPresenter;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class SingUpActivity extends AppCompatActivity implements SignUpContract.View {

    private TextInputLayout tilUser;
    private TextInputLayout tilPassword;
    private TextInputLayout tilEmail;
    private TextInputLayout tilConfirmPassword;
    private SignUpContract.Presenter presenter;

    private TextInputEditText tieUser;
    private TextInputEditText tiePassword;
    private TextInputEditText tieEmail;
    private TextInputEditText tieConfirmPassword;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);

        //Recogemos el nombre del usuario
         tieUser = findViewById(R.id.tieUser);

        //Recogemos la primera contraseña
         tiePassword = findViewById(R.id.tiePassword);

        //Recogemos la contraseña de confirmacion
         tieConfirmPassword = findViewById(R.id.tieConfirmPassword);

        //Recogemos email
         tieEmail = findViewById(R.id.tieEmail);

        //Empieza los inputLayout

        //Recogemos el nombre del usuario
         tilUser = findViewById(R.id.tilUser);

        //Recogemos la primera contraseña
         tilPassword = findViewById(R.id.tilPassword);

        //Recogemos la contraseña de confirmacion
        tilConfirmPassword = findViewById(R.id.tilConfirmPassword);

        //Recogemos email
         tilEmail = findViewById(R.id.tilEmail);

        presenter = new SignUpPresenter(this);
    }

    /**
     * Metodo que comprueba si es valido el usuario, la contraseña y el email
     */
    public void signUp(){
        presenter.addUser(tieUser.toString(),tiePassword.toString(),tieConfirmPassword.toString(),tieEmail.toString());
    }



    /**
     * Se da de alta el usuario y pasamos a la pantalla Login
     */
    @Override
    public void onSuccess() {
        Intent intent = new Intent( SingUpActivity.this, InventoryActivity.class);
        startActivity(intent);
    }

    @Override
    public void setPasswordsNotEqualError() {

    }

    @Override
    public void setUserAlreadyExists() {

    }

    @Override
    public void setEmailError() {

    }

    @Override
    public void setUserEmptyError() {

    }

    @Override
    public void setPasswordFormatError() {

    }

    @Override
    public void setPasswordEmptyError() {

    }
}