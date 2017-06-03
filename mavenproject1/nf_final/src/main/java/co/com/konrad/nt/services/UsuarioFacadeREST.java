/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.konrad.nt.services;

import co.com.konrad.nt.dao.UsuarioInput;
import co.com.konrad.nt.entities.Usuario;
import co.com.konrad.nt.entities.Usuario_;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.util.List;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author DesarrolloMovil_1
 */
@Stateless
@Path("usuario")
public class UsuarioFacadeREST extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "trimage")
    private EntityManager em;

    public UsuarioFacadeREST() {
        super(Usuario.class);
    }

    @POST
    @Override
    @Path("signin")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String create(Usuario entity) throws Exception{
         JsonObject res = new JsonObject();
        res.addProperty("codigo", 200);
        res.addProperty("mensaje", "operacion exitosa");
        try{
            super.create(entity);
            Gson gson = new Gson();
            javax.persistence.criteria.CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
            javax.persistence.criteria.CriteriaQuery cq = cb.createQuery();
            javax.persistence.criteria.Root<Usuario> rt = cq.from(Usuario.class);
            cq.where(
                    cb.equal(rt.get( Usuario_.usuarioCorreo), entity.getUsuarioCorreo()),
                    cb.equal(rt.get( Usuario_.usuarioClave), entity.getUsuarioClave())
            );
            javax.persistence.TypedQuery<Usuario> q = getEntityManager().createQuery(cq);
            Usuario user = q.getSingleResult();
            res.addProperty("data", gson.toJson(user));
        }catch(Throwable e){
            res.addProperty("codigo", 400);
            res.addProperty("mensaje", "operacion exitosa");
            System.out.println(""+e.getMessage());
        }
        return res.toString();
    }


    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Usuario find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Usuario> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Usuario> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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

    @POST
    @Path("login")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    private String login(Usuario userInput) throws Exception{
        
        JsonObject res = new JsonObject();
        try{
            res.addProperty("codigo", 200);
            res.addProperty("mensaje", "operacion exitosa");
            Gson gson = new Gson();
            javax.persistence.criteria.CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
            javax.persistence.criteria.CriteriaQuery cq = cb.createQuery();
            javax.persistence.criteria.Root<Usuario> rt = cq.from(Usuario.class);
            cq.where(
                    cb.equal(rt.get( Usuario_.usuarioCorreo), userInput.getUsuarioCorreo()),
                    cb.equal(rt.get( Usuario_.usuarioClave), userInput.getUsuarioClave())
            );
            javax.persistence.TypedQuery<Usuario> q = getEntityManager().createQuery(cq);
            Usuario user = q.getSingleResult();
            res.addProperty("data", gson.toJson(user));
        } catch (Throwable ex) {
            res.addProperty("codigo", 400);
            res.addProperty("mensaje", "operacion fallida");
        }
        return res.toString();
    }
    
}
