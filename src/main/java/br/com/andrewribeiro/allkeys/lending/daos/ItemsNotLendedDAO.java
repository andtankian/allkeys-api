package br.com.andrewribeiro.allkeys.lending.daos;

import br.com.andrewribeiro.allkeys.models.Item;
import br.com.andrewribeiro.ribrest.core.persistence.CRUDDAOImpl;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author Andrew Ribeiro
 */
public class ItemsNotLendedDAO extends CRUDDAOImpl {

    @Override
    public void read() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = builder.createQuery();
        Root root = criteriaQuery.from(Item.class);
        criteriaQuery.select(root);
        
        Predicate okOrNull = builder.or(
                builder.equal(root.get("currentStatus"), "Ok"),
                builder.isNull(root.get("currentStatus"))
        );
        
        criteriaQuery.where(okOrNull);
        flowContainer.getHolder().setModels(entityManager.createQuery(criteriaQuery).getResultList());
    }

}
