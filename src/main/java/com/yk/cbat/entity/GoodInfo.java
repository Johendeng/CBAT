package com.yk.cbat.entity;

import javax.persistence.*;

/**
 * Created by JohenTeng on 2017/8/28.
 */
@Entity
public class GoodInfo {
    private String goodId;
    private String goodName;
    private double goodPrice;
    private GoodItems GoodItems;
    @Id
    public String getGoodId() {
        return goodId;
    }

    public void setGoodId(String goodId) {
        this.goodId = goodId;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public double getGoodPrice() {
        return goodPrice;
    }

    public void setGoodPrice(double goodPrice) {
        this.goodPrice = goodPrice;
    }
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="itemId",nullable = false)
    public GoodItems getGoodItems() {
        return GoodItems;
    }

    public void setGoodItems(GoodItems GoodItems) {
        this.GoodItems = GoodItems;
    }
}
