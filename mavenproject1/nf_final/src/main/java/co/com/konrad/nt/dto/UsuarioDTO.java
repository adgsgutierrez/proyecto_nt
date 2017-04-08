package co.com.konrad.nt.dto;

import java.util.ArrayList;

public class UsuarioDTO {
	
    private Integer id;
    private String correo;
    private String clave;
    private String avatar;
    private String nombre;
    
    private ArrayList<TarjetaDTO> tarjetas;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<TarjetaDTO> getTarjetas() {
        return tarjetas;
    }

    public void setTarjetas(ArrayList<TarjetaDTO> tarjetas) {
        this.tarjetas = tarjetas;
    }
    
}
