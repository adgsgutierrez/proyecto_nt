/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.konrad.nt.ws;


import co.com.konrad.nt.logic.ImagenesLogic;
import com.google.gson.Gson;
import java.io.InputStream;
import javax.imageio.stream.FileImageInputStream;
import javax.imageio.stream.ImageInputStream;
import javax.ws.rs.Consumes;
import javax.ws.rs.PathParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

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
    @Path("/misImagenes/")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public String capturaImagenes(@FormDataParam("file") InputStream uploadedInputStream, 
            @FormDataParam("file")FormDataContentDisposition fileDetail ,@FormDataParam("id_user") String id){
        ImagenesLogic img = new ImagenesLogic();
        img.guardarFile(uploadedInputStream,fileDetail , id);
       // return gson.toJson();
       return "<script src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js\"></script>"
               + "<script> $(document).ready(function(){window.location.href = 'http://localhost:8080/nf_final/bodega.html';});</script>";
    }

}
