package com.myapp.admin2d.models;

import android.text.Editable;

public class D2 {
    String id;
    int morningNum, eveningNum;
    long date;

    public D2() {
    }

    public D2(String id, int morningNum, int eveningNum, long date) {
        this.id = id;
        this.morningNum = morningNum;
        this.eveningNum = eveningNum;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getMorningNum() {
        return morningNum;
    }

    public void setMorningNum(int morningNum) {
        this.morningNum = morningNum;
    }

    public int getEveningNum() {
        return eveningNum;
    }

    public void setEveningNum(int eveningNum) {
        this.eveningNum = eveningNum;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }
}
