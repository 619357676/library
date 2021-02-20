package com.gaoao.domain;

import java.util.List;

public class Borrow {
    private int record;
    private int uid;
    private int bid;
    private String borrowTime;
    private String returnTime;

    public Borrow() {
    }

    public Borrow(int record, int uid, int bid, String borrowTime, String returnTime) {
        this.record = record;
        this.uid = uid;
        this.bid = bid;
        this.borrowTime = borrowTime;
        this.returnTime = returnTime;
    }

    public int getRecord() {
        return record;
    }

    public void setRecord(int record) {
        this.record = record;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getBorrowTime() {
        return borrowTime;
    }

    public void setBorrowTime(String borrowTime) {
        this.borrowTime = borrowTime;
    }

    public String getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(String returnTime) {
        this.returnTime = returnTime;
    }

    @Override
    public String toString() {
        return "Borrow{" +
                "record=" + record +
                ", uid=" + uid +
                ", bid=" + bid +
                ", borrowTime='" + borrowTime + '\'' +
                ", returnTime='" + returnTime + '\'' +
                '}';
    }
}
