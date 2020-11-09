package com.example.inventory.iu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.inventory.R;
import com.example.inventory.presenter.AddUserContract;
import com.example.inventory.presenter.UserPresenter;
import com.example.inventory.presenter.ValidateUserContract;

public class LoginActivity extends AppCompatActivity implements AddUserContract.Presenter, AddUserContract.View{

    private ValidateUserContract.Presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        presenter = new UserPresenter(this);
    }

    public void showSignUp(View view){
        Intent intent = new Intent( LoginActivity.this, SingUpActivity.class);
        startActivity(intent);
    }


    /**
     * Metodo que valida si el inicio de sesion es correcto
     * @param view
     */
    public void validateUser(View view)
    {
        presenter.validateUser("Israel","Israel");

    }
    @Override
    public void addUser(String user, String password, String email) {

    }

    @Override
    public void emailDuplicated() {

    }

    @Override
    public void onSuccess() {
        Intent intent = new Intent(LoginActivity.this,InventoryActivity.class);
        startActivity(intent);
    }
}