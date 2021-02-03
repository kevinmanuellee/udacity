package com.udacity.jdnd.course3.Repository;

import com.udacity.jdnd.course3.Entity.Delivery;
import com.udacity.jdnd.course3.Entity.Plant;
import com.udacity.jdnd.course3.RecipientAndPrice;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class DeliveryRepository {

    @PersistenceContext
    EntityManager entityManager;

    public RecipientAndPrice getBill(Long deliveryId){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<RecipientAndPrice> query = cb.createQuery(RecipientAndPrice.class);
        Root<Plant> from = query.from(Plant.class);
        query.select(
            cb.construct(RecipientAndPrice.class,
                from.get("delivery").get("name"),
                cb.sum(from.get("price")))
        ) .where(cb.equal(from.get("delivery").get("id"), deliveryId));

        return entityManager.createQuery(query).getSingleResult();
    }

    public void persist(Delivery delivery){
        entityManager.persist(delivery);
    }

    public List<Delivery> findAllByName(String name){
        TypedQuery<Delivery> namedQuery = entityManager.createNamedQuery("Delivery.findAllByName", Delivery.class);
        namedQuery.setParameter("name", name);
        return namedQuery.getResultList();
    }

    public Delivery find(Long id){
        Delivery delivery = entityManager.find(Delivery.class, id);
        return delivery;
    }

    public Delivery merge(Delivery delivery){
        Delivery mergedDelivery = entityManager.merge(delivery);
        return mergedDelivery;
    }

    public void delete(Long id){
        Delivery delivery = entityManager.find(Delivery.class, id);
        entityManager.remove(delivery);
    }
}
