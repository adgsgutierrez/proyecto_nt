/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.konrad.nt.persistencia;

/**
 *
 * @author ADGS
 */
public class UsuarioSqlConstantes {
    
    public static String iniciar_sesion(String usuario , String clave){
        return "SELECT * FROM usuario WHERE usuario.usuario_correo = '"+usuario+"' AND usuario_clave = '"+clave+"'";
    }
    
    public static String crear_contacto(String correo , String clave , String nombre){
        return "INSERT usuario (usuario_correo , usuario_clave , usuario_nombre , usuario_avatar) VALUES "
                + "('"+correo+"','"+clave+"','"+nombre+"','img/default.jpg')";
    }
}
