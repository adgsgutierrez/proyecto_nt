/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.konrad.nt.services;

import co.com.konrad.nt.entities.Imagen;
import co.com.konrad.nt.entities.Usuario;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

/**
 *
 * @author DesarrolloMovil_1
 */
@Stateless
@Path("imagenes")
public class ImagenFacadeREST extends AbstractFacade<Imagen> {

    @PersistenceContext(unitName = "trimage")
    private EntityManager em;

    public ImagenFacadeREST() {
        super(Imagen.class);
    }
/*
    
         JsonObject res = new JsonObject();
        res.addProperty("codigo", 200);
        res.addProperty("mensaje", "operacion exitosa");
        try{
            super.create(entity);
        }catch(Throwable e){
            res.addProperty("codigo", 400);
            res.addProperty("mensaje", "operacion exitosa");
            System.out.println(""+e.getMessage());
        }
        return res.toString();
    }
*/
    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Imagen entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Imagen find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Path("my/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String findAll(@PathParam("id") Integer id) {
        Gson gson = new Gson();
        String sql = "SELECT * FROM imagen WHERE usuario_usuario_id = ?";
        Query query = getEntityManager().createNativeQuery(sql);
        query.setParameter(1 , id);
        List<Imagen> lista = query.getResultList();
        return gson.toJson(lista);
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Imagen> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public static final String RUTE_IMG = "C:\\Users\\ADGS\\Documents\\Universidad\\Materias\\Nuevas Tecnologias\\proyectos\\proyecto_nt\\mavenproject1\\nf_final\\src\\main\\webapp\\bodega\\";
    
    @POST
        @Path("misImagenes")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public String create (@FormDataParam("file") InputStream uploadedInputStream, 
            @FormDataParam("file")FormDataContentDisposition fileDetail ,@FormDataParam("id_user") String id
     ,@FormDataParam("id_nombre") String nombre ,@FormDataParam("id_costo") String costo ,@FormDataParam("id_descripcion") String descripcion)throws Exception {
         String extension = "";
        int i = fileDetail.getFileName().lastIndexOf('.');
        if (i > 0) {
            extension = fileDetail.getFileName().substring(i+1);
        }
        try{
         Date fecha = new Date();
        String target =  "IMG"+ fecha.getTime() + "." + extension;
            OutputStream out = null;
            int read = 0;
            byte[] bytes = new byte[1024];
            out = new FileOutputStream(new File(RUTE_IMG + target));
            while ((read = uploadedInputStream.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            out.flush();
            out.close();
            Gson gson = new Gson();
            Usuario user = gson.fromJson(id, Usuario.class);
            Imagen imagen = new Imagen();
            imagen.setImagenCosto(Integer.parseInt(costo));
            imagen.setImagenDescripcion(descripcion);
            imagen.setImagenNombre(nombre);
            imagen.setImagenFull("bodega/"+target);
            imagen.setImagenMin("bodega/"+target);
            imagen.setImagenEstado("V");
            imagen.setImagenFecha(new Date());
            imagen.setUsuarioUsuarioId(user);        
            String INSERT = "INSERT INTO `imagen` ( `imagen_nombre`, `imagen_descripcion`, `imagen_fecha`, `imagen_estado`, "
                    + "`imagen_costo`, `imagen_min`, `imagen_full`, `usuario_usuario_id`) "
                    + "VALUES ( ?, ?,?, 'V', ?, ?, ?, ?);";
            Query query = getEntityManager().createNativeQuery(INSERT);
            query.setParameter(1 , imagen.getImagenNombre());
            query.setParameter(2 , imagen.getImagenDescripcion());
            query.setParameter(3 , imagen.getImagenFecha());
            query.setParameter(4 , imagen.getImagenCosto());
            query.setParameter(5 , imagen.getImagenMin());
            query.setParameter(6 , imagen.getImagenFull());
            query.setParameter(7 , imagen.getUsuarioUsuarioId().getUsuarioId());
            query.executeUpdate();
        }catch(Throwable e){
            System.out.println(""+e.getMessage());
        }
       // return gson.toJson();
       return "<script src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js\"></script>"
            + "<script> $(document).ready(function(){window.location.href = 'http://localhost:8080/nf_final/bodega.html';});</script>";
    }

}
