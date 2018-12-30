package it.unisalento.model.persistence.inter;

import it.unisalento.model.UserEntity;
import it.unisalento.model.details.User;

import java.util.List;

public interface UserDao {
    void save(UserEntity user);

    List<UserEntity> list();

    UserEntity getByUsernameAndPassword(User user);

    void update(UserEntity user);

    void delete(UserEntity user);
}

