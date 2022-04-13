package com.hyb.entity;

import java.util.Date;

public class History {

    private Integer hid;
    private Integer bid;
    private Integer uid;
    private Date startTime;
    private Date endTime;
    private Date realTime;
    private Integer punctuality;//是否准时：0准时 1不准时

    private Book book;
    private User user;

    public History() {
    }

    public History(Integer hid, Integer bid, Integer uid, Date startTime, Date endTime, Date realTime, Integer punctuality, Book book, User user) {
        this.hid = hid;
        this.bid = bid;
        this.uid = uid;
        this.startTime = startTime;
        this.endTime = endTime;
        this.realTime = realTime;
        this.punctuality = punctuality;
        this.book = book;
        this.user = user;
    }

    @Override
    public String toString() {
        return "History{" +
                "hid=" + hid +
                ", bid=" + bid +
                ", uid=" + uid +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", realTime=" + realTime +
                ", punctuality=" + punctuality +
                ", book=" + book +
                ", user=" + user +
                '}';
    }

    public Integer getHid() {
        return hid;
    }

    public void setHid(Integer hid) {
        this.hid = hid;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getRealTime() {
        return realTime;
    }

    public void setRealTime(Date realTime) {
        this.realTime = realTime;
    }

    public Integer getPunctuality() {
        return punctuality;
    }

    public void setPunctuality(Integer punctuality) {
        this.punctuality = punctuality;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
