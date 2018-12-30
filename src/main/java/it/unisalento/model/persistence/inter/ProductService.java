package it.unisalento.model.persistence.inter;

import it.unisalento.model.ProductEntity;

import java.util.List;

public interface ProductService {
    void save(ProductEntity ProductEntity);

    List<ProductEntity> list();

    ProductEntity getFromId(String id);

    void update(ProductEntity ProductEntity);

    void delete(ProductEntity ProductEntity);
}
