package com.example.inventory.iu.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonUtils {
    /**
     * Metodo estatico que comprueba si la contraseña es valida
     * >= 8 caracteres
     * 1 mayúscula
     * 1 número
     * @param password
     * @return
     */
    public static boolean isPasswordValid(String password) {
        Pattern pattern = Pattern.compile("([A-Z][a-z]){8,20}");
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
