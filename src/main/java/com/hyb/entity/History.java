package com.hyb.entity;

import java.util.Date;

public class History {

    private Integer hid;
    private Book book;
    private User user;
    private Date startTime;
    private Date endTime;
    private Date realTime;
    private Integer punctuality;//是否准时：0准时 1不准时

    public History() {
    }

    public History(Integer hid, Book book, User user, Date startTime, Date endTime, Date realTime, Integer punctuality) {
        this.hid = hid;
        this.book = book;
        this.user = user;
        this.startTime = startTime;
        this.endTime = endTime;
        this.realTime = realTime;
        this.punctuality = punctuality;
    }

    @Override
    public String toString() {
        return "History{" +
                "hid=" + hid +
                ", book=" + book +
                ", user=" + user +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", realTime=" + realTime +
                ", punctuality=" + punctuality +
                '}';
    }

    public Integer getHid() {
        return hid;
    }

    public void setHid(Integer hid) {
        this.hid = hid;
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
}
