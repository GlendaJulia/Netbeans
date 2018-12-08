/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author USER
 */
@Stateless
public class ConsultantStatusFacade extends AbstractFacade<ConsultantStatus> {

    @PersistenceContext(unitName = "WebApp08PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ConsultantStatusFacade() {
        super(ConsultantStatus.class);
    }
    
}
