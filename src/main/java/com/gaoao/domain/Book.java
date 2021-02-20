package com.gaoao.domain;



public class Book {
    private int bid;//书的id
    private String name;//书名
    private String author;//作者
    private String pubDate;//出版日期
    private String pubHouse;//出版社
    private int page;//总页数
    private String classify;
    private String clc;//中图分类号
    private String introduction;//简介

    private int num;
    private int loan;//可借数量

    public Book() {
    }

    public Book(int bid, String name, String author, String pubDate, String pubHouse, int page, String classify, String clc, String introduction, int num, int loan) {
        this.bid = bid;
        this.name = name;
        this.author = author;
        this.pubDate = pubDate;
        this.pubHouse = pubHouse;
        this.page = page;
        this.classify = classify;
        this.clc = clc;
        this.introduction = introduction;
        this.num = num;
        this.loan = loan;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getPubHouse() {
        return pubHouse;
    }

    public void setPubHouse(String pubHouse) {
        this.pubHouse = pubHouse;
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getClc() {
        return clc;
    }

    public void setClc(String clc) {
        this.clc = clc;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getLoan() {
        return loan;
    }

    public void setLoan(int loan) {
        this.loan = loan;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bid=" + bid +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", pubDate='" + pubDate + '\'' +
                ", pubHouse='" + pubHouse + '\'' +
                ", page=" + page +
                ", classify='" + classify + '\'' +
                ", clc='" + clc + '\'' +
                ", introduction='" + introduction + '\'' +
                ", num=" + num +
                ", loan=" + loan +
                '}';
    }
}
