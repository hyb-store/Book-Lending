package com.hyb.entity;

import java.util.Date;

public class History {

    private Integer hid;
    private Integer lUid;
    private Integer bid;
    private Integer bUid;
    private Date startTime;
    private Date endTime;
    private Date realTime;
    private Integer punctuality;//是否准时：0准时 1不准时

    private User lUser;
    private Book book;
    private User bUser;

    public History() {
    }

    public History(Integer hid, Integer lUid, Integer bid, Integer bUid,
                   Date startTime, Date endTime, Date realTime, Integer punctuality,
                   User lUser, Book book, User bUser) {
        this.hid = hid;
        this.lUid = lUid;
        this.bid = bid;
        this.bUid = bUid;
        this.startTime = startTime;
        this.endTime = endTime;
        this.realTime = realTime;
        this.punctuality = punctuality;
        this.lUser = lUser;
        this.book = book;
        this.bUser = bUser;
    }

    @Override
    public String toString() {
        return "History{" +
                "hid=" + hid +
                ", lUid=" + lUid +
                ", bid=" + bid +
                ", bUid=" + bUid +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", realTime=" + realTime +
                ", punctuality=" + punctuality +
                ", lUser=" + lUser +
                ", book=" + book +
                ", bUser=" + bUser +
                '}';
    }

    public Integer getHid() {
        return hid;
    }

    public void setHid(Integer hid) {
        this.hid = hid;
    }

    public Integer getlUid() {
        return lUid;
    }

    public void setlUid(Integer lUid) {
        this.lUid = lUid;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public Integer getbUid() {
        return bUid;
    }

    public void setbUid(Integer bUid) {
        this.bUid = bUid;
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

    public User getlUser() {
        return lUser;
    }

    public void setlUser(User lUser) {
        this.lUser = lUser;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getbUser() {
        return bUser;
    }

    public void setbUser(User bUser) {
        this.bUser = bUser;
    }
}
