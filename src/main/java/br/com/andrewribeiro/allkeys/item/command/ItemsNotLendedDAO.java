package br.com.andrewribeiro.allkeys.item.command;

import br.com.andrewribeiro.allkeys.models.Item;
import br.com.andrewribeiro.ribrest.dao.CRUDDAOImpl;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
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
        Join itemLendingsJoin = root.join("lendings", JoinType.LEFT);
        criteriaQuery = criteriaQuery.select(root).where(
                builder.or(
                        builder.equal(itemLendingsJoin.get("status"), "Devolvido"),
                        builder.isNull(itemLendingsJoin.get("status"))
                )
        );
        flowContainer.getHolder().setModels(entityManager.createQuery(criteriaQuery).getResultList());
    }

}
