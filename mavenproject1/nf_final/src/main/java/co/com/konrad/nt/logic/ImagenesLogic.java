/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.konrad.nt.logic;

import co.com.konrad.nt.dao.Imagen;
import co.com.konrad.nt.dto.ResponseDTO;
import co.com.konrad.nt.utils.Constantes;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
/**
 *
 * @author cesar
 */
public class ImagenesLogic {
   
    private ResponseDTO response;
    private final EntityManager em;

    public ImagenesLogic() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(Constantes.CONEXION);
        this.em = emf.createEntityManager();
    }
    
    public ResponseDTO guardarFile(InputStream inStream, 
            FormDataContentDisposition fileDetail , String usuario , String nombre , String costo , String descripcion){
        Date fecha = new Date();

        String extension = "";
        int i = fileDetail.getFileName().lastIndexOf('.');
        if (i > 0) {
            extension = fileDetail.getFileName().substring(i+1);
        }
        String target = Constantes.RUTE_IMG + usuario +"_"+ fecha.getTime() + "." + extension;
        try{
            OutputStream out = null;
            int read = 0;
            byte[] bytes = new byte[1024];
            out = new FileOutputStream(new File(target));
            while ((read = inStream.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            out.flush();
            out.close();
            
            Imagen imagen = new Imagen();
            imagen.setImagenCosto(Integer.parseInt(costo));
            imagen.setImagenDescripcion(descripcion);
            imagen.setImagenNombre(nombre);
            imagen.setImagenFull(target);
            imagen.setImagenEstado("V");
            imagen.setImagenFecha(new Date());
            
            em.getTransaction().begin();
            em.persist(imagen);
            em.flush();
            em.getTransaction().commit();
            
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Error en guardar File "+e.getMessage());
        }
        return response;
    }
}
