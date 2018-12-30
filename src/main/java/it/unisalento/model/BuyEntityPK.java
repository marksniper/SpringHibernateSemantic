package it.unisalento.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

public class BuyEntityPK implements Serializable {
    private int userIdUser;
    private int productIdProduct;
    private Timestamp date;

    @Column(name = "USER_idUSER", nullable = false)
    @Id
    public int getUserIdUser() {
        return userIdUser;
    }

    public void setUserIdUser(int userIdUser) {
        this.userIdUser = userIdUser;
    }

    @Column(name = "PRODUCT_idPRODUCT", nullable = false)
    @Id
    public int getProductIdProduct() {
        return productIdProduct;
    }

    public void setProductIdProduct(int productIdProduct) {
        this.productIdProduct = productIdProduct;
    }

    @Column(name = "date", nullable = false)
    @Id
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
        BuyEntityPK that = (BuyEntityPK) o;
        return userIdUser == that.userIdUser &&
                productIdProduct == that.productIdProduct &&
                Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userIdUser, productIdProduct, date);
    }
}
