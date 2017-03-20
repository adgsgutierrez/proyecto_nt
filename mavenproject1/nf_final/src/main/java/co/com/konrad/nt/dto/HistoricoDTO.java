/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.konrad.nt.dto;

import java.util.Date;

/**
 *
 * @author ADGS
 */
public class HistoricoDTO {
    
    private String fecha;
    private String nombre_imagen;
    private String ruta_imagen;
    private String nombre_usuario;
    private String tipo;
    private String estado;
    private String valor;

    public HistoricoDTO(String fecha, String nombre_imagen, String ruta_imagen, String nombre_usuario, String tipo, String estado, String valor) {
        this.fecha = fecha;
        this.nombre_imagen = nombre_imagen;
        this.ruta_imagen = ruta_imagen;
        this.nombre_usuario = nombre_usuario;
        this.tipo = tipo;
        this.estado = estado;
        this.valor = valor;
    }
    
    @Override
    public String toString() {
        return "HistoricoDTO{" + "fecha=" + fecha + ", nombre_imagen=" + nombre_imagen + ", ruta_imagen=" + ruta_imagen + ", nombre_usuario=" + nombre_usuario + ", tipo=" + tipo + ", estado=" + estado + ", valor=" + valor + '}';
    }
    
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNombre_imagen() {
        return nombre_imagen;
    }

    public void setNombre_imagen(String nombre_imagen) {
        this.nombre_imagen = nombre_imagen;
    }

    public String getRuta_imagen() {
        return ruta_imagen;
    }

    public void setRuta_imagen(String ruta_imagen) {
        this.ruta_imagen = ruta_imagen;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
    
    
}
