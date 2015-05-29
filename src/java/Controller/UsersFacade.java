/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Users;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Antonio
 */
@Stateless
public class UsersFacade extends AbstractFacade<Users> {
    @PersistenceContext(unitName = "trabalho-pwPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    private EntityManager getPrivateEntityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("trabalho-pwPU");
        return emf.createEntityManager();
    }

    public UsersFacade() {
        super(Users.class);
    }
    
    public Users findNamedQuery(String namedQuery, String param, String value) {       
        TypedQuery<Users> query = getPrivateEntityManager().createNamedQuery(namedQuery, Users.class);
        query.setParameter(param, value);         
        return query.getSingleResult();
    }
    
}
