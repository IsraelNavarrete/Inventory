package com.example.inventory.iu.signup;


public class SignUpPresenter implements SignUpContract.Presenter, SignUpInteractorImpl.SignUpInteractor{

    private SignUpContract.View view;
    private SignUpInteractorImpl interactor;
    public SignUpPresenter(SignUpContract.View view) {
        this.view=view;
        this.interactor= new SignUpInteractorImpl(this);
    }

    /**
     * Este método viene del contrato SignUpContract.Presenter
     * @param user
     * @param password
     * @param confirmPassword
     * @param email
     */
    @Override
    public void validateUser(String user, String password, String confirmPassword, String email) {
        view.showProgressDialog();

        //El interactor realiza las acciones oportunas con el usuario y el password - Validará el usuario
        interactor.validateUser(user, password,confirmPassword,email);
    }

    @Override
    public void onDestroy() {
        view = null;
        interactor = null;
    }

    @Override
    public void onUserEmptyError() {
        view.hideProgressDialog();
        view.setUserEmptyError();
    }

    @Override
    public void onPasswordEmptyError() {
        view.hideProgressDialog();
        view.setPasswordEmptyError();
    }

    @Override
    public void onPasswordFormatError() {
        view.hideProgressDialog();
        view.setPasswordFormatError();
    }

    @Override
    public void onAuthenticationError() {
        view.hideProgressDialog();
        view.setAuthenticationError();
    }

    @Override
    public void showProgressDialog() {

    }

    @Override
    public void hideProgressDialog() {

    }


    @Override
    public void onPasswordsNotEqualError() {
        view.hideProgressDialog();
        view.setPasswordsNotEqualError();
    }

    @Override
    public void onUserAlreadyExists() {
        view.hideProgressDialog();
        view.setUserAlreadyExists();
    }

    @Override
    public void onEmailEmptyError() {
        view.hideProgressDialog();
        view.setEmailEmptyError();
    }

    @Override
    public void onEmailFormatError() {
        view.hideProgressDialog();
        view.setEmailFormatError();
    }

    @Override
    public void onSuccess() {

    }
}
