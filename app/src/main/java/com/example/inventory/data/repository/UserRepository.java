package com.example.inventory.data.repository;

import com.example.inventory.data.model.User;

/**
 * Esta clase será accesible desde cualquier punto de la aplicacion
 * Se accedera mediante el metodo estatico getInstance)= que devuelve
 * la instancia del repositorio que siempre se inicializa en un bloque
 * estatico
 */
public class UserRepository {
    private static UserRepository repository;
    private User user;

    /**
     * Se inicializa las propiedades estáticas del repositorio
     * en el bloque static
     */
    static {
        repository=new UserRepository();
    }
    //Constructor privado donde se incicializaran las variables de objeto.
    private UserRepository(){
        user = new User(1,"Israel","israelnavarreterodriguez@gmail.com","israel","israel");
    }

    public static UserRepository getInstance(){
        //No es necesario comprobar si es null porque se ha inicializado
        //en el bloque static
        return repository;
    }
}
