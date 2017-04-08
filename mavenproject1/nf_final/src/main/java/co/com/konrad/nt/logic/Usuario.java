package co.com.konrad.nt.logic;

import co.com.konrad.nt.dto.ResponseNT;
import co.com.konrad.nt.dto.UsuarioDTO;
import co.com.konrad.nt.constant.Constant;
import co.com.konrad.nt.persistencia.ConecctionDB;
import co.com.konrad.nt.persistencia.UsuarioSqlConstantes;
import co.com.konrad.nt.utils.Utils;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

public class Usuario {

    private ConecctionDB conexion ;
    public Usuario() {
    }
    /**
     * Metodo para el inicio de sesion en la aplicacion
     * @param usuario : correo del usuario
     * @param clave : es la clave de acceso de cada usuario
     * @return Objeto de tipo ResponseNt, en donde el campo Data: se encuentra la clase usuarioDTO, con todos los datos del usuario
     **/
    public ResponseNT iniciar_sesion(String usuario, String clave) {
        System.out.println("USER " + usuario + " PWD " + clave);
        Boolean flag = Boolean.FALSE;
        ResponseNT response = new ResponseNT();
        response.setCode(Constant.CODE_ERROR_GENERAL);
        response.setMessage(Constant.SMS_ERROR_GENERAL);
        response.setData(null);
        if(Utils.validar_inicio(usuario,clave)){
            try{
                conexion = new ConecctionDB();
                ResultSet resultado;
                resultado = conexion.search(UsuarioSqlConstantes.iniciar_sesion(usuario,clave));
                while(resultado.next()){
                    UsuarioDTO user = new UsuarioDTO();
                    user.setId(resultado.getInt("usuario_id"));
                    user.setNombre(resultado.getString("usuario_nombre"));
                    user.setCorreo(resultado.getString("usuario_correo"));
                    user.setAvatar(resultado.getString("usuario_avatar"));
                    response.setCode(Constant.CODE_SUCCESS);
                    response.setMessage(Constant.SMS_SUCCESS);
                    response.setData(user);
                }
                if(response.getData() == null){
                    response.setCode(Constant.CODE_ERROR_PWD_USER);
                    response.setMessage(Constant.SMS_ERROR_PWD_USER);
                    response.setData(null);
                }
            }catch(SQLException ex){
                System.out.println("Error SQL "+ex.getSQLState());
                response.setCode(Constant.CODE_ERROR_USER_NOT_EXIST);
                response.setMessage(Constant.SMS_ERROR_USER_NOT_EXIST);
                response.setData(null);
            }
        }else{
            response.setCode(Constant.CODE_ERROR_USER_NOT_EXIST);
            response.setMessage(Constant.SMS_ERROR_USER_NOT_EXIST);
            response.setData(null);
        }
        return response;
    }
     /**
     * Metodo para el historico del usuario
     * @param usuario : es el id que se retorna en el inicio de sesion
     * @return Objeto de tipo ResponseNt, en donde el campo Data: se encuentra un arrayList de tipo HistoricoDTO
     **/
    public ResponseNT historico_usuario(Integer usuario) {
        System.out.println("Usuario "+usuario);
        ResponseNT response = new ResponseNT();
        response.setCode(Constant.CODE_ERROR_GENERAL);
        response.setMessage(Constant.SMS_ERROR_GENERAL);
        response.setData(null);
       // ArrayList historico = HistoricoConstant.getHistorial(usuario);
        /*if (!historico.isEmpty()) {
            response.setCode(Constant.CODE_SUCCESS);
            response.setMessage(Constant.SMS_SUCCESS);
            response.setData(historico);
        }else{
            response.setCode(Constant.CODE_HISTORY_NO_FOUND);
            response.setMessage(Constant.SMS_HISTORY_NO_FOUND);
            response.setData(null);        
         }*/
        return response;
    }
    /**
     * Metodo para agregar contactos
     * @param usuario : es el id que se retorna en el inicio de sesion
     * @param contacto : es el id del contacto a agregar
     * @return Objeto de tipo ResponseNt, en donde el campo Data: un booleano de exitoso si se pudo agregar
     **/
    public ResponseNT agregar_contacto(Integer usuario , Integer contacto){
        System.out.println("Usuario "+usuario + " CONTACTO " +contacto);
        ResponseNT response = new ResponseNT();
        response.setCode(Constant.CODE_ERROR_GENERAL);
        response.setMessage(Constant.SMS_ERROR_GENERAL);
        response.setData(null);
        Boolean estado = Boolean.TRUE;
        if (usuario < 5) {
            response.setCode(Constant.CODE_SUCCESS);
            response.setMessage(Constant.SMS_SUCCESS);
            response.setData(estado);
        }else{
            estado = Boolean.FALSE;
            response.setCode(Constant.CODE_NOT_CONTACT_ADD);
            response.setMessage(Constant.SMS_NOT_CONTACT_ADD);
            response.setData(estado);        
         }
        return response;
    }
    /**
     * Metodo para agregar tarjetas de credito
     * @param usuario : es el id que se retorna en el inicio de sesion
     * @param numero : es el numero de la tarjeta a agregar
     * @param fecha : es la fecha de vencimiento de la tarjeta
     * @param pago_automatico : es el indicador si el pago se dispara automaticamente
     * @return Objeto de tipo ResponseNt, en donde el campo Data: un booleano de exitoso si se pudo agregar
     **/
    public ResponseNT agregar_tarjeta(Integer usuario , String numero , String fecha , Boolean pago_automatico){
        System.out.println("Usuario "+usuario + " NUMERO " +numero + " FECHA "+fecha+" PAGO_AUT "+pago_automatico);
        ResponseNT response = new ResponseNT();
        response.setCode(Constant.CODE_ERROR_GENERAL);
        response.setMessage(Constant.SMS_ERROR_GENERAL);
        response.setData(null);
        Boolean estado = Boolean.TRUE;
        if (usuario < 5) {
            response.setCode(Constant.CODE_SUCCESS);
            response.setMessage(Constant.SMS_SUCCESS);
            response.setData(estado);
        }else{
            estado = Boolean.FALSE;
            response.setCode(Constant.CODE_NOT_CREDIT_ADD);
            response.setMessage(Constant.SMS_NOT_CREDIT_ADD);
            response.setData(estado);        
         }
        return response;
    }
}
