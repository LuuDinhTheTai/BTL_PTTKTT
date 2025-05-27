package com.utc.Searching.q29;

import com.utc.Searching.q24.StudentList;

public class Q29 {
    public static void main(String[] args) {
        // Khởi tạo danh sách sinh viên từ file sv.csv
        StudentList list = new StudentList("sv.csv");

        // Tổng kết điểm trung bình học kỳ 1 cho toàn lớp
        System.out.println("--- TỔNG KẾT ĐIỂM TB HỌC KỲ 1 ---");
        list.TongKetHK(1);

        // Tổng kết điểm trung bình học kỳ 2 cho toàn lớp
        System.out.println("\n--- TỔNG KẾT ĐIỂM TB HỌC KỲ 2 ---");
        list.TongKetHK(2);
    }
}