package it.unisalento.model.persistence.impl;

import it.unisalento.model.ProductEntity;
import it.unisalento.model.persistence.inter.ProductDao;
import it.unisalento.model.persistence.inter.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImp implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    @Transactional
    public void save(ProductEntity product) {
        productDao.save(product);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductEntity> list() {
        return productDao.list();
    }

    @Override
    @Transactional(readOnly = true)
    public ProductEntity getFromId(String id) {
        return productDao.getFromId(id);
    }

    @Override
    @Transactional()
    public void update(ProductEntity product) {
        productDao.update(product);
    }

    @Override
    @Transactional()
    public void delete(ProductEntity product) {
        productDao.delete(product);
    }


}
