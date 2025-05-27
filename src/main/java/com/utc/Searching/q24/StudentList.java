package com.utc.Searching.q24;

import com.utc.Searching.q23.BinarySearchST;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class StudentList {
  
  private BinarySearchST<String, Student> list;
  
  public StudentList() {
    list = new BinarySearchST<>();
  }
  
  public StudentList(String filename) {
    list = new BinarySearchST<>();
    load(filename);
  }
  
  public void load(String filename) {
    try (Scanner scanner = new Scanner(new File(filename))) {
      while (scanner.hasNextLine()) {
        com.utc.Searching.q24.Student student = new com.utc.Searching.q24.Student(scanner.nextLine());
        list.put(student.getMaSV(), student);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  // In theo mã (default trong st)
  public void printByMaSV() {
    for (String ma : list.keys()) {
      System.out.println(list.get(ma));
    }
  }
  
  // In theo tên
  public void printByTen() {
    List<Student> students = new ArrayList<>();
    for (String ma : list.keys()) students.add(list.get(ma));
    students.sort(Comparator.comparing(Student::getTen).thenComparing(Student::getHoDem));
    for (Student sv : students) {
      System.out.println(sv);
    }
  }
  
  public void put(Student student) {
    list.put(student.getMaSV(), student);
  }
  
  public Student find(String maSV) {
    return list.get(maSV);
  }
  
  public Student get(String maSV) {
    return list.get(maSV);
  }
  
  public Iterable<String> keys() {
    return list.keys();
  }
  
  public int size() {
    return list.size();
  }
  
  // Tổng kết học kỳ của lớp
  public void TongKetHK(int kyThu) {
    System.out.println("MaSV\t\tDiemTB_HK" + kyThu);
    for (String maSV : list.keys()) {
      Student sv = list.get(maSV);
      double dtbHK = sv.tinhTBchungHK(kyThu);
      System.out.printf("%s\t%.2f\n", maSV, dtbHK);
    }
  }
}