/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.konrad.nt.ws;

import co.com.konrad.nt.dto.ResponseNT;
import com.google.gson.Gson;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author ADGS
 */
@Path("usuario")
public class Usuario {
    
    @Context
    private UriInfo context;
    private final Gson gson = new Gson();
    private co.com.konrad.nt.logic.Usuario usuario;

    @POST
    @Path("login")
    @Produces(MediaType.TEXT_PLAIN)
    public String getLogin(@QueryParam("usuario") String usuario , @QueryParam("clave") String clave){
        this.usuario = new co.com.konrad.nt.logic.Usuario();
        ResponseNT respuesta = this.usuario.iniciar_sesion(usuario,clave);
        return this.gson.toJson(respuesta);
    }
    
    @POST
    @Path("historico")
    @Produces(MediaType.TEXT_PLAIN)
    public String getHistorico(@QueryParam("usuario") Integer id_usuario){
        this.usuario = new co.com.konrad.nt.logic.Usuario();
        ResponseNT respuesta = this.usuario.historico_usuario(id_usuario);
        return this.gson.toJson(respuesta);
    }
    
    @POST
    @Path("adicionar/contacto")
    @Produces(MediaType.TEXT_PLAIN)
    public String agregar_contacto(@QueryParam("usuario") Integer id_usuario , @QueryParam("contacto") Integer contacto){
        this.usuario = new co.com.konrad.nt.logic.Usuario();
        ResponseNT respuesta = this.usuario.agregar_contacto(id_usuario, contacto);
        return this.gson.toJson(respuesta);
    }
    @POST
    @Path("adicionar/tarjeta_credito")
    @Produces(MediaType.TEXT_PLAIN)
    public String agregar_tarjeta(@QueryParam("usuario") Integer id_usuario , @QueryParam("numero") String numero, @QueryParam("fecha") String fecha, @QueryParam("automatico") Boolean pago){
        this.usuario = new co.com.konrad.nt.logic.Usuario();
        ResponseNT respuesta = this.usuario.agregar_tarjeta(id_usuario, numero , fecha , pago);
        return this.gson.toJson(respuesta);
    }
}
