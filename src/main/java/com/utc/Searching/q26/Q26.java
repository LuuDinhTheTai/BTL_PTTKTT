package com.utc.Searching.q26;

import com.utc.Searching.q24.StudentList;

import java.util.HashSet;
import java.util.Set;

public class Q26 {

  public static void main(String[] args) throws Exception {
    Mon toan = new Mon("Toan", 3, 1);
    Mon hoa = new Mon("Hoa", 2, 1);

    BangDiem bangDiemToan = new BangDiem(toan, "toan3.csv");
    BangDiem bangDiemHoa = new BangDiem(hoa, "hoa2.csv");

    StudentList studentList = new StudentList("sv.csv");
    Iterable<String> maSVList = studentList.keys();

    for (String maSV : maSVList) {
      double tongDiem = 0;
      int tongTC = 0;

      if (bangDiemToan.getBangDiem().contains(maSV)) {
        float diem = bangDiemToan.find(maSV);
        int soTC = toan.getSoTC();
        tongDiem += diem * soTC;
        tongTC += soTC;
      }

      if (bangDiemHoa.getBangDiem().contains(maSV)) {
        float diem = bangDiemHoa.find(maSV);
        int soTC = hoa.getSoTC();
        tongDiem += diem * soTC;
        tongTC += soTC;
      }

      double tbc = tongTC == 0 ? 0 : tongDiem / tongTC;
      System.out.printf("Student ID: %s, Average: %.2f\n", maSV, tbc);
    }
  }
}
