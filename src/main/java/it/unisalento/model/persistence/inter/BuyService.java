package it.unisalento.model.persistence.inter;

import it.unisalento.model.BuyEntity;
import it.unisalento.model.ProductEntity;
import it.unisalento.model.UserEntity;

import java.util.List;

public interface BuyService {
    void save(BuyEntity buyEntity);

    List<Object[]> list();

    List<Object[]> listBuy(UserEntity userEntity, ProductEntity productEntity);

    List<Object[]> listBuyUser(UserEntity userEntity);

    BuyEntity buyFromTimeStamp(String timeStamp);

    void update(BuyEntity buyEntity);

    void delete(BuyEntity buyEntity);
}
