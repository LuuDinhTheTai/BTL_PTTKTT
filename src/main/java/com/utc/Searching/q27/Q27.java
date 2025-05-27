package com.utc.Searching.q27;

import com.utc.Searching.q23.BinarySearchST;
import com.utc.Searching.q24.Student;
import com.utc.Searching.q24.StudentList;
import com.utc.Searching.q26.BangDiem;
import com.utc.Searching.q26.Mon;

import java.util.Scanner;

public class Q27 {

    public static void main(String[] args) {
        Mon mon = new Mon("Toán", 3, 1);

        StudentList list = new StudentList("sv.csv");
        BinarySearchST<String, Student> dsLop = new BinarySearchST<>();
        for (String maSV : list.keys()) {
            dsLop.put(maSV, list.get(maSV));
        }

        BangDiem bangDiem = new BangDiem(mon);

        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Nhập điểm môn " + mon.getTenMon() + " ===");
        for (String maSV : dsLop.keys()) {
            Student sv = dsLop.get(maSV);
            System.out.print("Nhập điểm cho sinh viên " + sv + ": ");
            float diem = -1f;
            while (true) {
                try {
                    diem = Float.parseFloat(scanner.nextLine());
                    if (diem < 0 || diem > 10) {
                        System.out.print("Điểm không hợp lệ. Nhập lại (0-10): ");
                    } else {
                        break;
                    }
                } catch (Exception e) {
                    System.out.print("Sai định dạng. Nhập lại (0-10): ");
                }
            }
            bangDiem.put(maSV, diem);
        }

        System.out.println("\n--- Bảng điểm môn " + mon.getTenMon() + " ---");
        for (String maSV : dsLop.keys()) {
            System.out.println(maSV + " - " + dsLop.get(maSV).toString() +
                               " - Điểm: " + bangDiem.find(maSV));
        }
    }
}