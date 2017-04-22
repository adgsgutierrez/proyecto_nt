/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.konrad.nt.logic;

import co.com.konrad.nt.dao.Usuario;
import co.com.konrad.nt.dao.Usuario_;
import co.com.konrad.nt.dto.ResponseDTO;
import co.com.konrad.nt.dto.UsuarioDTO;
import co.com.konrad.nt.utils.Constantes;
import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author ADGS
 */
public class UsuarioLogic implements Serializable{
    private ResponseDTO response;
    private final EntityManager em;
    
    public UsuarioLogic() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(Constantes.CONEXION);
        this.em = emf.createEntityManager();
    }
    /***
     * Este metodo es el encargado de consultar un usuario en la base de datos
     * y retornar su información basica
     * @param usuario : es el usuario que se desea consultar, solo se requiere 
     *                  el correo y la clave y son de tipo UsuarioDTO
     * @return ResponseDTO : es el objeto generico de respuesta que tendrá la aplicación
     **/
    public ResponseDTO iniciar_sesion(UsuarioDTO usuario){
        response = new ResponseDTO();
        response.setCodigo(Constantes.C_EXITOSO);
        response.setMensaje(Constantes.M_EXITOSO);
        try{
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Usuario> cq = cb.createQuery(Usuario.class);
            Root<Usuario> root= cq.from(Usuario.class);
            cq.where(
                    cb.equal(root.get(Usuario_.usuarioCorreo), usuario.getUsuario()),
                    cb.equal(root.get(Usuario_.usuarioClave), usuario.getClave())
            );
            TypedQuery<Usuario> q = em.createQuery(cq);
            Usuario user = q.getSingleResult();
            usuario.setAvatar(user.getUsuarioAvatar());
            usuario.setNombre(user.getUsuarioNombre());
            usuario.setId(user.getUsuarioId());
            response.setData(usuario);
        }catch(Exception e){
            response.setCodigo(Constantes.C_NOT_USUARIO);
            response.setMensaje(Constantes.M_NOT_USUARIO);
            response.setData(null);
        }
        return response;
    }
    /***
     * Este metodo es el encargado de crear un usuario en la base de datos
     * y retornar su información basica, para su inicio de sesion
     * @param usuario : es el usuario que se desea crear, se requiere 
     *                  el correo, la clave , nombre , el avatar es opcional
     *                  y son de tipo UsuarioDTO
     * @return ResponseDTO : es el objeto generico de respuesta que tendrá la aplicación
     **/
    public ResponseDTO crear_usuario(UsuarioDTO usuario){
        response = new ResponseDTO();
        response.setCodigo(Constantes.C_EXITOSO);
        response.setMensaje(Constantes.M_EXITOSO);
        System.out.println("Usuario "+usuario.toString());
        try{
            Usuario user = new Usuario();
            user.setUsuarioNombre(usuario.getNombre());
            user.setUsuarioClave(usuario.getClave());
            user.setUsuarioCorreo(usuario.getUsuario());
            user.setUsuarioAvatar(usuario.getAvatar());
            
            em.getTransaction().begin();
            em.persist(user);
            em.flush();
            em.getTransaction().commit();
        
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Usuario> cq = cb.createQuery(Usuario.class);
            Root<Usuario> root= cq.from(Usuario.class);
            cq.where(
                    cb.equal(root.get(Usuario_.usuarioCorreo), usuario.getUsuario()),
                    cb.equal(root.get(Usuario_.usuarioClave), usuario.getClave())
            );
            TypedQuery<Usuario> q = em.createQuery(cq);
            Usuario userResponse = q.getSingleResult();
            usuario.setAvatar(userResponse.getUsuarioAvatar());
            usuario.setNombre(userResponse.getUsuarioNombre());
            usuario.setId(userResponse.getUsuarioId());
            response.setData(usuario);
            
        }catch(Exception e){
            System.out.println("Error de tipo "+e.getMessage());
            response.setCodigo(Constantes.C_NOT_USUARIO);
            response.setMensaje(Constantes.M_NOT_USUARIO);
            response.setData(null);
        }
        return response;
    }
}
