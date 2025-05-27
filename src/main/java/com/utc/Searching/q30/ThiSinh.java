package com.utc.Searching.q30;

import java.util.Objects;

public class ThiSinh {
    private String hoDem;
    private String ten;
    private String ngaySinh;
    private double dtbChungPT;

    public ThiSinh(String hoDem, String ten, String ngaySinh, double dtbChungPT) {
        this.hoDem = hoDem;
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        this.dtbChungPT = dtbChungPT;
    }

    public String getHoDem() {
        return hoDem;
    }

    public String getTen() {
        return ten;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public double getDtbChungPT() {
        return dtbChungPT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ThiSinh thiSinh)) return false;
        return Double.compare(thiSinh.dtbChungPT, dtbChungPT) == 0 &&
                Objects.equals(hoDem, thiSinh.hoDem) &&
                Objects.equals(ten, thiSinh.ten) &&
                Objects.equals(ngaySinh, thiSinh.ngaySinh);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hoDem, ten, ngaySinh, dtbChungPT);
    }

    @Override
    public String toString() {
        return hoDem + " " + ten + " (" + ngaySinh + ") - ĐTBPT: " + dtbChungPT;
    }
}