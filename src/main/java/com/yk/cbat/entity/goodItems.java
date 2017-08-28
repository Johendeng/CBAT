package com.yk.cbat.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by JohenTeng on 2017/8/28.
 */
@Entity
public class goodItems {
    private String itemId;
    private String itemName;

    @Id
    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
