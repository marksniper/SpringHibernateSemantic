package it.unisalento.model.persistence.impl;

import it.unisalento.model.UserEntity;
import it.unisalento.model.details.User;
import it.unisalento.model.persistence.inter.UserDao;
import it.unisalento.model.persistence.inter.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public void save(UserEntity user) {
        userDao.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserEntity> list() {
        return userDao.list();
    }

    @Override
    @Transactional(readOnly = true)
    public UserEntity getgetByUsernameAndPassword(User user) {
        return userDao.getByUsernameAndPassword(user);
    }

    @Override
    @Transactional()
    public void update(UserEntity user) {
        userDao.update(user);
    }

    @Override
    @Transactional()
    public void delete(UserEntity user) {
        userDao.delete(user);
    }


}
