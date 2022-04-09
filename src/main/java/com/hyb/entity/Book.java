package com.hyb.entity;

import java.util.Date;
import java.util.List;

public class Book {
    private Integer bid;
    private String bookName;
    private String author;
    private String press;
    private Date pubTime;
    private Type type;
    private String bookImg;
    private String description;
    private User user;
    private Integer status;
    private Integer count;

    private List<Comment> comments;//评论

    public Book() {
    }

    @Override
    public String toString() {
        return "Book{" +
                "bid=" + bid +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", press='" + press + '\'' +
                ", pubTime=" + pubTime +
                ", type=" + type +
                ", bookImg='" + bookImg + '\'' +
                ", description='" + description + '\'' +
                ", user=" + user +
                ", status=" + status +
                ", count=" + count +
                ", comments=" + comments +
                '}';
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Book(Integer bid, String bookName, String author, String press, Date pubTime, Type type, String bookImg, String description, User user, Integer status, Integer count, List<Comment> comments) {
        this.bid = bid;
        this.bookName = bookName;
        this.author = author;
        this.press = press;
        this.pubTime = pubTime;
        this.type = type;
        this.bookImg = bookImg;
        this.description = description;
        this.user = user;
        this.status = status;
        this.count = count;
        this.comments = comments;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public Date getPubTime() {
        return pubTime;
    }

    public void setPubTime(Date pubTime) {
        this.pubTime = pubTime;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getBookImg() {
        return bookImg;
    }

    public void setBookImg(String bookImg) {
        this.bookImg = bookImg;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
