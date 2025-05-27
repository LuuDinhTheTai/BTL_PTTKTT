package com.utc.Searching.q28;

import com.utc.Searching.q24.Student;
import com.utc.Searching.q26.Mon;
import com.utc.Sorting.q12.Date;

public class Q28 {
    public static void main(String[] args) {
        // Tạo một sinh viên
        Student sv = new Student("123456", "Nguyen Van", "A", new Date(1,1,2000), "Ha Noi");
        
        // Tạo các môn học với số tín chỉ và kỳ học khác nhau
        Mon toan = new Mon("Toán", 3, 1);
        Mon ly   = new Mon("Lý", 2, 1);
        Mon hoa  = new Mon("Hóa", 2, 2);
        Mon van  = new Mon("Văn", 2, 2);

        // Thêm điểm cho các môn học vào bảng điểm của sinh viên
        sv.getBangDiem().put(toan, 8.0);
        sv.getBangDiem().put(ly, 7.0);
        sv.getBangDiem().put(hoa, 6.0);
        sv.getBangDiem().put(van, 9.0);

        // Tính trung bình chung học kỳ 1
        double tbHK1 = sv.tinhTBchungHK(1);
        System.out.printf("Điểm trung bình chung học kỳ 1: %.2f\n", tbHK1);

        // Tính trung bình chung học kỳ 2
        double tbHK2 = sv.tinhTBchungHK(2);
        System.out.printf("Điểm trung bình chung học kỳ 2: %.2f\n", tbHK2);
    }
}