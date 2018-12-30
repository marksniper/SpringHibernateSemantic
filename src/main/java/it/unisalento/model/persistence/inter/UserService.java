package it.unisalento.model.persistence.inter;

import it.unisalento.model.UserEntity;
import it.unisalento.model.details.User;

import java.util.List;

public interface UserService {
    void save(UserEntity user);

    List<UserEntity> list();

    UserEntity getgetByUsernameAndPassword(User user);

    void update(UserEntity user);

    void delete(UserEntity user);
}
