package it.unisalento.model.persistence.impl;

import it.unisalento.model.UserEntity;
import it.unisalento.model.details.User;
import it.unisalento.model.persistence.inter.UserDao;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {
    public static final Logger log = LoggerFactory.getLogger(UserDaoImp.class);
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(UserEntity user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public List<UserEntity> list() {
        try {
            TypedQuery<UserEntity> query = sessionFactory.getCurrentSession().createQuery("from UserEntity");
            return query.getResultList();
        } catch (NoResultException e) {
            log.debug("Not user find. Return null");
            return null;
        }
    }

    @Override
    public UserEntity getByUsernameAndPassword(User user) {
        try {
            TypedQuery<UserEntity> query = sessionFactory.getCurrentSession().createQuery(
                    "from UserEntity where username='" + user.getUsername() + "' and password='" + user.getPassword() + "'");
            return query.getSingleResult();
        } catch (NoResultException e) {
            log.debug("Not user find. Return null");
            return null;
        }
    }

    @Override
    public void update(UserEntity user) {
        sessionFactory.getCurrentSession().update(user);
    }

    @Override
    public void delete(UserEntity user) {
        sessionFactory.getCurrentSession().remove(user);
    }
}
