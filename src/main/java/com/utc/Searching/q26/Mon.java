package com.utc.Searching.q26;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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
}