package com.utc.Sorting.q13;

import com.utc.Sorting.q12.Date;

import java.util.PriorityQueue;
import java.util.Stack;

public class Student implements Comparable<Student> {
  
  private String hoTen;
  private Date ngaySinh;
  private float DtbChung;
  
  public Student(String hoTen, Date ngaySinh, float DtbChung) {
    this.hoTen = hoTen;
    this.ngaySinh = ngaySinh;
    this.DtbChung = DtbChung;
  }
  
  @Override
  public String toString() {
    return this.hoTen + " - " + this.ngaySinh.toString() + " - " + this.DtbChung;
  }
  
  @Override
  public int compareTo(Student o) {
    return (int) this.DtbChung - (int) o.DtbChung;
  }
  
  public static void main(String[] args) {
    Student[] a = new Student[]{
            new Student("A", new Date(1, 1, 2000), 100),
            new Student("B", new Date(1, 1, 2000), 77),
            new Student("C", new Date(1, 1, 2000), 88),
            new Student("D", new Date(1, 1, 2000), 23),
            new Student("E", new Date(1, 1, 2000), 75),
    };
    
    for (Student s : a) {
        System.out.println(s);
    }
  }
}
