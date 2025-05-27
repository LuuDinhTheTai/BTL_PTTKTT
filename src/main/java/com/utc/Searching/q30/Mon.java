package com.utc.Searching.q30;

import java.util.Objects;

public class Mon implements Comparable<Mon> {
    
    private String tenMon;
    private int soTC;
    private int kyThu;

    public Mon(String tenMon, int soTC, int kyThu) {
        this.tenMon = tenMon;
        this.soTC = soTC;
        this.kyThu = kyThu;
    }

    public String getTenMon() {
        return tenMon;
    }

    public int getSoTC() {
        return soTC;
    }

    public int getKyThu() {
        return kyThu;
    }

    @Override
    public int compareTo(Mon o) {
        return tenMon.compareTo(o.tenMon);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mon mon)) return false;
        return soTC == mon.soTC &&
                kyThu == mon.kyThu &&
                Objects.equals(tenMon, mon.tenMon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tenMon, soTC, kyThu);
    }
}