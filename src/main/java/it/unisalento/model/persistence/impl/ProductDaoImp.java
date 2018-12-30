package it.unisalento.model.persistence.impl;

import it.unisalento.model.ProductEntity;
import it.unisalento.model.persistence.inter.ProductDao;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ProductDaoImp implements ProductDao {
    public static final Logger log = LoggerFactory.getLogger(ProductDaoImp.class);
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(ProductEntity product) {
        sessionFactory.getCurrentSession().save(product);
    }

    @Override
    public List<ProductEntity> list() {
        try {
            TypedQuery<ProductEntity> query = sessionFactory.getCurrentSession().createQuery("from ProductEntity ");
            return query.getResultList();
        } catch (
                NoResultException e) {
            log.debug("Not user find. Return null");
            return null;
        }
    }

    @Override
    public ProductEntity getFromId(String id) {
        try {
            TypedQuery<ProductEntity> query = sessionFactory.getCurrentSession().createQuery(
                    "from ProductEntity where idProduct=" + id + "");
            return query.getSingleResult();
        } catch (
                NoResultException e) {
            log.debug("Not user find. Return null");
            return null;
        }
    }

    @Override
    public void update(ProductEntity product) {
        sessionFactory.getCurrentSession().update(product);
    }

    @Override
    public void delete(ProductEntity product) {
        sessionFactory.getCurrentSession().remove(product);
    }
}
