package it.unisalento.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "BUY", schema = "DATABASE", catalog = "")
@IdClass(BuyEntityPK.class)
public class BuyEntity {
    private int userIdUser;
    private int productIdProduct;
    private Timestamp date;

    @Id
    @Column(name = "USER_idUSER", nullable = false)
    public int getUserIdUser() {
        return userIdUser;
    }

    public void setUserIdUser(int userIdUser) {
        this.userIdUser = userIdUser;
    }

    @Id
    @Column(name = "PRODUCT_idPRODUCT", nullable = false)
    public int getProductIdProduct() {
        return productIdProduct;
    }

    public void setProductIdProduct(int productIdProduct) {
        this.productIdProduct = productIdProduct;
    }

    @Id
    @Column(name = "date", nullable = false)
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BuyEntity buyEntity = (BuyEntity) o;
        return userIdUser == buyEntity.userIdUser &&
                productIdProduct == buyEntity.productIdProduct &&
                Objects.equals(date, buyEntity.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userIdUser, productIdProduct, date);
    }
}
