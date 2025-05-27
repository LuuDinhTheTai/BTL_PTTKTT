package com.utc.Searching.q24;

import java.io.File;
import java.util.Scanner;

public class Q24 {
  
  public static void main(String[] args) {
    StudentList students = new StudentList();
    try (Scanner scanner = new Scanner(new File("sv.csv"))) {
      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        Student student = new Student(line);
        students.put(student);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    // In ra tất cả sinh viên
    System.out.println("--- Danh sách sinh viên ---");
    for (String maSV : students.keys()) {
      System.out.println(students.get(maSV));
    }
  }
}
