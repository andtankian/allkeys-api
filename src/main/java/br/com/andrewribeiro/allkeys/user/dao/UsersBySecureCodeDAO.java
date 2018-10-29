package br.com.andrewribeiro.allkeys.user.dao;

import br.com.andrewribeiro.allkeys.models.User;
import br.com.andrewribeiro.ribrest.core.persistence.CRUDDAOImpl;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.ws.rs.core.Response;

/**
 *
 * @author Andrew Ribeiro
 */
public class UsersBySecureCodeDAO extends CRUDDAOImpl{

    @Override
    public void read() {
        User user = (User)flowContainer.getModel();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery criteria = builder.createQuery();
        Root userRoot = criteria.from(User.class);
        criteria.select(userRoot).where(builder.equal(userRoot.get("secureCode"), user.getSecureCode()));        
        flowContainer.getHolder().setModels(entityManager.createQuery(criteria).getResultList());
        if(flowContainer.getHolder().getModels().isEmpty()){
            flowContainer.getResult().setStatus(Response.Status.NO_CONTENT);
        }
    }
    
    

}
