/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.konrad.nt.dto;

/**
 *
 * @author ADGS
 */

public class ResponseDTO {
    
    private Integer codigo;
    private String mensaje;
    private Object data;

    @Override
    public String toString() {
        return "ResponseDTO{" + "codigo=" + codigo + ", mensaje=" + mensaje + ", data=" + data + '}';
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
   
}
