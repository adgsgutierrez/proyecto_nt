/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.konrad.nt.ws;

import co.com.konrad.nt.dto.UsuarioDTO;
import co.com.konrad.nt.logic.UsuarioLogic;
import com.google.gson.Gson;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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
   
    @POST
    @Path("login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String getLogin(UsuarioDTO usuario){
        UsuarioLogic usuariologic = new UsuarioLogic();
        return gson.toJson(usuariologic.iniciar_sesion(usuario));
    }

    @POST
    @Path("signin")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String getSignIn(UsuarioDTO usuario){
        UsuarioLogic usuariologic = new UsuarioLogic();
        return gson.toJson(usuariologic.crear_usuario(usuario));
    }
    
    @POST
    @Path("editUser")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String profile(UsuarioDTO usuario) {
        UsuarioLogic usuariologic = new UsuarioLogic();
        return gson.toJson(usuariologic.editar_usuario(usuario));
    }
}
