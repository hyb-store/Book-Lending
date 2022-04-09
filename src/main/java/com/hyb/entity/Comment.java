package com.hyb.entity;

import java.util.Date;

public class Comment {

    private Integer cid;
    private Integer bid;
    private Integer uid;
    private Date commentTime;
    private String content;

    private User user;

    public Comment() {
    }

    public Comment(Integer cid, Integer bid, Integer uid, Date commentTime, String content, User user) {
        this.cid = cid;
        this.bid = bid;
        this.uid = uid;
        this.commentTime = commentTime;
        this.content = content;
        this.user = user;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
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

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "cid=" + cid +
                ", bid=" + bid +
                ", uid=" + uid +
                ", commentTime=" + commentTime +
                ", content='" + content + '\'' +
                ", user=" + user +
                '}';
    }
}
