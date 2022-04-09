package com.hyb.entity;

public class Type {

    private Integer tid;
    private String typeName;

    public Type() {
    }

    public Type(Integer tid, String typeName) {
        this.tid = tid;
        this.typeName = typeName;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "Type{" +
                "tid=" + tid +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}
