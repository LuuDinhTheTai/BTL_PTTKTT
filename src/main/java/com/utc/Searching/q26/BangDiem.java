package com.utc.Searching.q26;

import com.utc.Searching.q23.BinarySearchST;

import java.io.File;
import java.util.Scanner;

public class BangDiem {

  private BinarySearchST<String, Float> bangDiem;
  private Mon mon;

  public BangDiem(Mon mon) {
    this.mon = mon;
    this.bangDiem = new BinarySearchST<>();
  }
  
  public BangDiem(Mon mon, String filename) {
    this.mon = mon;
    this.bangDiem = new BinarySearchST<>();
    load(filename);
  }

  public void load(String filename) {
    try (Scanner scanner = new Scanner(new File(filename))) {
      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        String[] data = line.split(",");
        
        String maSV = data[0].trim();
        float diem = Float.parseFloat(data[1].trim());
        
        bangDiem.put(maSV, diem);
      }
      
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public float find(String maSV) {
    return bangDiem.get(maSV);
  }

  public void put(String maSV, float diem) {
    bangDiem.put(maSV, diem);
  }

  public Mon getMon() {
    return mon;
  }

  public BinarySearchST<String, Float> getBangDiem() {
    return bangDiem;
  }
}
