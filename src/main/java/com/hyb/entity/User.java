package com.hyb.entity;

import java.util.Date;
import java.util.List;

public class User {
    private Integer uid;
    private String openId;
    private String username;
    private Integer gender;
    private String address;
    private String phoneNum;
    private String email;
    private Integer scores;
    private Date registerTime;
    private Integer role;

    private List<Book> myBooks;//我的借书
    private List<History> record;//借书记录

    public User() {
    }


    public User(Integer uid, String openId, String username, Integer gender, String address, String phoneNum, String email, Integer scores, Date registerTime, Integer role, List<Book> myBooks, List<History> record) {
        this.uid = uid;
        this.openId = openId;
        this.username = username;
        this.gender = gender;
        this.address = address;
        this.phoneNum = phoneNum;
        this.email = email;
        this.scores = scores;
        this.registerTime = registerTime;
        this.role = role;
        this.myBooks = myBooks;
        this.record = record;
    }

    public Integer getId() {
        return uid;
    }

    public void setId(Integer uid) {
        this.uid = uid;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getScores() {
        return scores;
    }

    public void setScores(Integer scores) {
        this.scores = scores;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public List<Book> getMyBooks() {
        return myBooks;
    }

    public void setMyBooks(List<Book> myBooks) {
        this.myBooks = myBooks;
    }

    public List<History> getRecord() {
        return record;
    }

    public void setRecord(List<History> record) {
        this.record = record;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", openId='" + openId + '\'' +
                ", username='" + username + '\'' +
                ", gender=" + gender +
                ", address='" + address + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", email='" + email + '\'' +
                ", scores=" + scores +
                ", registerTime=" + registerTime +
                ", role=" + role +
                ", myBooks=" + myBooks +
                ", record=" + record +
                '}';
    }
}
