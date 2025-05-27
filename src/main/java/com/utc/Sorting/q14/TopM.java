package com.utc.Sorting.q14;

import com.utc.Sorting.q12.Date;
import com.utc.Sorting.q13.Student;
import edu.princeton.cs.algs4.Transaction;

import java.util.PriorityQueue;
import java.util.Stack;

public class TopM {
  public static void main(String[] args) {
    Student[] a = new Student[]{
            new Student("A", new Date(1, 4, 2000), 100),
            new Student("B", new Date(1, 22, 2000), 77),
            new Student("C", new Date(2, 5, 2000), 88),
            new Student("D", new Date(5, 3, 2000), 23),
            new Student("E", new Date(6, 21, 2000), 75),
            new Student("F", new Date(8, 12, 2000), 100)
    };
    
    PriorityQueue<Student> pq = new PriorityQueue<>();
    int m = 5;
    for (var x : a) {
      pq.add(x);
      if (pq.size() > m)
        pq.poll();
    }
    
    Stack<Student> stack = new Stack<>();
    while (!pq.isEmpty())
      stack.add(pq.poll());
    while (!stack.isEmpty())
      System.out.println(stack.pop());
  }
}
