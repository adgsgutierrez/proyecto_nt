/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.konrad.nt.services;

import co.com.konrad.nt.entities.Usuario;
import co.com.konrad.nt.entities.Usuario_;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.Expression;

/**
 *
 * @author DesarrolloMovil_1
 */
public abstract class AbstractFacade<T> {

    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public String create(T entity) throws Exception{
       try {
            getEntityManager().persist(entity);
        } catch (Throwable ex) {
            System.out.println("Se toteo "+ ex.getMessage());
        }
        return "";
    }

    public void edit(T entity) {
        getEntityManager().merge(entity);
    }

    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public List<T> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
    
    public Usuario login(String usuario , String clave){
        try{
            javax.persistence.criteria.CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
            javax.persistence.criteria.CriteriaQuery cq = cb.createQuery();
            javax.persistence.criteria.Root<Usuario> rt = cq.from(Usuario.class);
            cq.where(
                    cb.equal(rt.get( Usuario_.usuarioCorreo), usuario),
                    cb.equal(rt.get( Usuario_.usuarioClave), clave)
            );
            javax.persistence.TypedQuery<Usuario> q = getEntityManager().createQuery(cq);
            Usuario user = q.getSingleResult();
            return user;
        }catch(Exception e){
            System.out.println("Exception ");
            e.printStackTrace();
            return null;
        }
    }
    
}
