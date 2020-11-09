package com.example.inventory.presenter;

/**
 * Clase que controla la reglas de negocio de la clase User
 */
public class UserPresenter implements ValidateUserContract.Presenter, AddUserContract.Presenter {

    private UserView view;

    /**
     * En el constructor se inicializa la vista
     * @param view
     */
    public UserPresenter(UserView view) {
        this.view = view;
    }


    /**
     * Metodo que añade un usuario a la base de datos. Se tiene que gestionar
     * la RN-U5: No puede existir dos usuarios con el mismo email
     * @param user
     * @param password
     * @param email
     */
    public void addUser(String user, String password, String email) {
        //1. Se envia un mensaje al repositorio
        //1.1 Si es correcto
        view.onSuccess();

        //1.2 Si el usuario es duplicado
        ((AddUserContract.View)view).emailDuplicated();
    }

    public void validateUser(String email,String password) {
        //1. Se llama al metodo validateUser del repositorio
        //1.1 Si es correcto
        view.onSuccess();
        //1.2
        //((ValidateUserContract.View)view).emailError();
        //((ValidateUserContract.View)view).PasswordError();
    }

}
