package com.yk.cbat.entity;

import scala.xml.PrettyPrinter;

import javax.persistence.*;

/**
 * Created by JohenTeng on 2017/8/28.
 */
@Entity
public class goodInfo {
    private String goodId;
    private String goodName;
    private double goodPrice;
    private goodItems goodItems;
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
    public com.yk.cbat.entity.goodItems getGoodItems() {
        return goodItems;
    }

    public void setGoodItems(com.yk.cbat.entity.goodItems goodItems) {
        this.goodItems = goodItems;
    }
}
