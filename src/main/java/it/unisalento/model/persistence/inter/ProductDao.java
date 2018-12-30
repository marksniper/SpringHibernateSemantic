package it.unisalento.model.persistence.inter;

import it.unisalento.model.ProductEntity;

import java.util.List;

public interface ProductDao {
    void save(ProductEntity product);

    List<ProductEntity> list();

    ProductEntity getFromId(String id);

    void update(ProductEntity product);

    void delete(ProductEntity product);
}

