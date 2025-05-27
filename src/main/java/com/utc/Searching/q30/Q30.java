package com.utc.Searching.q30;

import java.util.Hashtable;

public class Q30 {
  
  public static void main(String[] args) {
    Hashtable<ThiSinh, Hashtable<Mon, Double>> bangDiem = new Hashtable<>();
    
    ThiSinh ts = new ThiSinh("Nguyen Van", "A", "01/01/2000", 8.5);
    Mon mon1 = new Mon("Toan", 4, 1);
    Mon mon2 = new Mon("Ly", 3, 1);
    
    Hashtable<Mon, Double> diem = new Hashtable<>();
    diem.put(mon1, 7.5);
    diem.put(mon2, 8.0);
    
    bangDiem.put(ts, diem);
    
    System.out.println(bangDiem);
    
  }
}
