package com.example.inventory.iu.signup;


import com.example.inventory.iu.base.BasePresenter;

public class SignUpPresenter implements SignUpContract.Presenter{

    private SignUpContract.View view;
    public SignUpPresenter(SignUpContract.View view) {
        this.view=view;
    }

    /**
     * Este método viene del contrato SignUpContract.Presenter
     * @param user
     * @param password
     * @param confirmPassword
     * @param email
     */
    @Override
    public void addUser(String user, String password, String confirmPassword, String email) {

    }

    @Override
    public void onDestroy() {
        view = null;
    }
}
