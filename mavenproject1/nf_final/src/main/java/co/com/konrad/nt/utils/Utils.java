/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.konrad.nt.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author ADGS
 */
public class Utils {
    
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    public static final Pattern VALID_PWD_REGEX = Pattern.compile("^[a-zA-Z0-9]*$");
    public static final Pattern VALID_NOMBRE_REGEX = Pattern.compile("^[a-zA-Z0-9\\s]*$");
    
    public static Boolean validar_inicio(String usuario , String clave){
        Matcher userMatcher = VALID_EMAIL_ADDRESS_REGEX .matcher(usuario); 
        Matcher pwdMatcher = VALID_PWD_REGEX .matcher(clave); 
        if(userMatcher.find()){
            if(pwdMatcher.find()){
                return true;
            }
        }
        return false;
    }
    
    public static Boolean crear_usuario(String usuario , String clave , String nombre){
        Matcher userMatcher = VALID_EMAIL_ADDRESS_REGEX.matcher(usuario); 
        Matcher pwdMatcher = VALID_PWD_REGEX.matcher(clave);
        Matcher nameMatcher = VALID_NOMBRE_REGEX.matcher(nombre);
        if(userMatcher.find()){
            if(pwdMatcher.find()){
                if(nameMatcher.find()){
                    return true;
                }
            }
        }
        return false;
    }
}
