/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.konrad.nt.ws;

import co.com.konrad.nt.dto.UsuarioDTO;
import co.com.konrad.nt.logic.UsuarioLogic;
import com.google.gson.Gson;
import java.io.File;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
/**
 *
 * @author cesar
 */
@Path("/imagenes")
public class Imagenes {
    @Context
    private UriInfo context;
    private final Gson gson = new Gson();
    
    @POST
    @Path("/misImagenes")
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED , MediaType.MULTIPART_FORM_DATA})
    @Produces(MediaType.MULTIPART_FORM_DATA)
    public String getImages(File imagen){

        System.out.println("Name "+imagen.getName());
        System.out.println("AbsolutPath "+imagen.getAbsolutePath());
        return "ingreso";
    }
}
