package it.unisalento.model.persistence.impl;

import it.unisalento.model.BuyEntity;
import it.unisalento.model.ProductEntity;
import it.unisalento.model.UserEntity;
import it.unisalento.model.persistence.inter.BuyDao;
import it.unisalento.model.persistence.inter.BuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BuyServiceImp implements BuyService {

    @Autowired
    private BuyDao buyDao;

    @Override
    @Transactional
    public void save(BuyEntity buy) {
        buyDao.save(buy);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Object[]> list() {
        return buyDao.list();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Object[]> listBuy(UserEntity userEntity, ProductEntity productEntity) {
        return buyDao.listBuy(userEntity, productEntity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Object[]> listBuyUser(UserEntity userEntity) {
        return buyDao.listBuyUser(userEntity);
    }

    @Override
    @Transactional(readOnly = true)
    public BuyEntity buyFromTimeStamp(String timeStamp) {
        return buyDao.buyFromTimeStamp(timeStamp);
    }

    @Override
    @Transactional()
    public void update(BuyEntity buy) {
        buyDao.update(buy);
    }

    @Override
    @Transactional()
    public void delete(BuyEntity buy) {
        buyDao.delete(buy);
    }


}
