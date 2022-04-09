package com.hyb.entity;

import java.util.Date;

public class Recommend {

    private Integer rid;
    private Integer uid;
    private Integer bid;
    private Integer val;
    private Date rTime;

    public Recommend() {
    }

    @Override
    public String toString() {
        return "Recommend{" +
                "rid=" + rid +
                ", uid=" + uid +
                ", bid=" + bid +
                ", val=" + val +
                ", rTime=" + rTime +
                '}';
    }

    public Recommend(Integer rid, Integer uid, Integer bid, Integer val, Date rTime) {
        this.rid = rid;
        this.uid = uid;
        this.bid = bid;
        this.val = val;
        this.rTime = rTime;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public Integer getVal() {
        return val;
    }

    public void setVal(Integer val) {
        this.val = val;
    }

    public Date getrTime() {
        return rTime;
    }

    public void setrTime(Date rTime) {
        this.rTime = rTime;
    }
}
