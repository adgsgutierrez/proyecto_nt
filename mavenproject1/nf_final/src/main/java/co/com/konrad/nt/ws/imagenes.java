/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.konrad.nt.ws;

import co.com.konrad.nt.dto.ResponseNT;
import com.google.gson.Gson;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
/**
 *
 * @author cesar
 */
@Path("imagenes")
public class imagenes {
    @Context
    private UriInfo context;
    private final Gson gson = new Gson();
    private co.com.konrad.nt.logic.Imagenes imagenes;
    
    @GET
    @Path("login")
    @Produces(MediaType.TEXT_PLAIN)
    public String getGallery(){
        this.imagenes = new co.com.konrad.nt.logic.Imagenes();
        ResponseNT respuesta = this.imagenes.getImagenes();
        return this.gson.toJson(respuesta);
    }
}
