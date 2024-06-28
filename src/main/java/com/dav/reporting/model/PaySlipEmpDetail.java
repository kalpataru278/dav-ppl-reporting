package com.dav.reporting.model;

public class PaySlipEmpDetail {
    private String c1Key;
    private String c2Key;
    private String c1Value;
    private String c2Value;

    public PaySlipEmpDetail(String c1Key, String c2Key, String c1Value, String c2Value) {
        this.c1Key = c1Key;
        this.c2Key = c2Key;
        this.c1Value = c1Value;
        this.c2Value = c2Value;
    }

    public String getC1Key() {
        return c1Key;
    }

    public void setC1Key(String c1Key) {
        this.c1Key = c1Key;
    }

    public String getC2Key() {
        return c2Key;
    }

    public void setC2Key(String c2Key) {
        this.c2Key = c2Key;
    }

    public String getC1Value() {
        return c1Value;
    }

    public void setC1Value(String c1Value) {
        this.c1Value = c1Value;
    }

    public String getC2Value() {
        return c2Value;
    }

    public void setC2Value(String c2Value) {
        this.c2Value = c2Value;
    }
}
