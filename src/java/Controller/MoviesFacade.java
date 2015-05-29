/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Movies;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Antonio
 */
@Stateless
public class MoviesFacade extends AbstractFacade<Movies> {
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

    public MoviesFacade() {
        super(Movies.class);
    }
    
}
