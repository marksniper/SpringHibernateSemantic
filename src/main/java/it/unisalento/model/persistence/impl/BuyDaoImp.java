package it.unisalento.model.persistence.impl;

import it.unisalento.model.BuyEntity;
import it.unisalento.model.ProductEntity;
import it.unisalento.model.UserEntity;
import it.unisalento.model.persistence.inter.BuyDao;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Repository
public class BuyDaoImp implements BuyDao {
    public static final Logger log = LoggerFactory.getLogger(BuyDaoImp.class);
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(BuyEntity buy) {
        sessionFactory.getCurrentSession().save(buy);
    }

    @Override
    public List<Object[]> list() {
        try {
            TypedQuery<Object[]> query = sessionFactory.getCurrentSession().createQuery(
                    " from BuyEntity, UserEntity, ProductEntity ");
            sessionFactory.getCurrentSession().flush();
            return query.getResultList();
        } catch (
                NoResultException e) {
            log.debug("Not user find. Return null");
            return null;
        }
    }

    @Override
    public List<Object[]> listBuy(UserEntity userEntity, ProductEntity productEntity) {
        try {
            TypedQuery<Object[]> query = sessionFactory.getCurrentSession().createQuery(
                    "from BuyEntity where userIdUser='" + userEntity.getIdUser() + "' and productIdProduct='" + productEntity.getIdProduct() + "'");
            sessionFactory.getCurrentSession().flush();
            return query.getResultList();
        } catch (NoResultException e) {
            log.debug("Not user find. Return null");
            return null;
        }
    }

    @Override
    public List<Object[]> listBuyUser(UserEntity userEntity) {
        try {
            int id;
            TypedQuery<Object[]> query = sessionFactory.getCurrentSession().createSQLQuery(
                    "SELECT BUY.date, PRODUCT.name, PRODUCT.price, PRODUCT.quantity FROM BUY, PRODUCT where" +
                            " BUY.USER_idUSER = " + userEntity.getIdUser() + " and  BUY.PRODUCT_idPRODUCT=PRODUCT.idPRODUCT;"
            );
            sessionFactory.getCurrentSession().flush();
            return query.getResultList();
        } catch (NoResultException e) {
            log.debug("Not user find. Return null");
            return null;
        }
    }
    @Override
    public BuyEntity buyFromTimeStamp(String timeStamp) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Date parsedDate = dateFormat.parse(timeStamp);
            Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
            TypedQuery<BuyEntity> query = sessionFactory.getCurrentSession().createQuery(
                    "from BuyEntity where date='" + timestamp + "'");
            return query.getSingleResult();
        } catch (NoResultException | ParseException e) {
            log.debug("Not user find. Return null");
            return null;
        }
    }
    @Override
    public void update(BuyEntity buy) {
        sessionFactory.getCurrentSession().update(buy);
        sessionFactory.getCurrentSession().flush();
    }
    @Override
    public void delete(BuyEntity buy) {
        sessionFactory.getCurrentSession().remove(buy);

    }
}
