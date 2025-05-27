package com.utc.Searching.q25;

import com.utc.Searching.q24.Student;
import com.utc.Searching.q24.StudentList;

public class Q25 {
  
  public static void main(String[] args) {
    StudentList list = new StudentList();
    list.load("sv.csv");
    
    System.out.println("--- Danh sách sinh viên theo mã ---");
    list.printByMaSV();
    
    System.out.println("--- Danh sách sinh viên theo tên ---");
    list.printByTen();
    
    System.out.println("--- Tìm sinh viên với mã 123456 ---");
    Student sv = list.find("123456");
    System.out.println(sv != null ? sv : "Không tìm thấy");
  }
}
