package it.unisalento.model.details;

import java.util.ArrayList;
import java.util.List;

public class BuysData {
    private String date;
    private String name;
    private String price;
    private String quantity;
    private List<BuysData> buysDataList;

    public BuysData(String date, String name, String price, String quantity) {
        this.date = date;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public BuysData() {
    }

    public List<BuysData> getBuysDataList() {
        return buysDataList;
    }

    public void createObjectJson(List<Object[]> object) {
        buysDataList = new ArrayList<>();
        for (Object[] o : object) {
            BuysData d = new BuysData(String.valueOf(o[0]),
                    String.valueOf(o[1]),
                    String.valueOf(o[2]),
                    String.valueOf(o[3]));
            buysDataList.add(d);
        }
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
