package com.it18zhang.eshop.model;

import java.sql.Timestamp;
import java.util.Date;

/**
 *UserItem
 */
public class UserItem {
    private int id ;
    private int userId ;
    private int itemId ;
    private int score ;
    private Date time = new Date() ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}

