package com.utc.Searching.q24;

import com.utc.Searching.q23.BinarySearchST;
import com.utc.Searching.q26.Mon;
import com.utc.Sorting.q12.Date;

public class Student {
    
    private String maSV;
    private String hoDem;
    private String ten;
    private Date ngaySinh;
    private String queQuan;
    
    BinarySearchST<Mon, Double> bangDiem = new BinarySearchST<>();

    public Student(String maSV, String hoDem, String ten, Date ngaySinh, String queQuan) {
        this.maSV = maSV;
        this.hoDem = hoDem;
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        this.queQuan = queQuan;
    }

    // Khởi tạo từ 1 dòng trong SV.csv
    public Student(String csvLine) {
        String[] arr = csvLine.split(",");
        this.maSV = arr[0].trim();
        this.hoDem = arr[1].trim();
        this.ten = arr[2].trim();
        this.ngaySinh = new Date(arr[3].trim(), true);
        this.queQuan = arr[4].trim();
    }

    public String getMaSV() { return maSV; }
    public String getHoDem() { return hoDem; }
    public String getTen() { return ten; }
    public Date getNgaySinh() { return ngaySinh; }
    public String getQueQuan() { return queQuan; }
    public BinarySearchST<Mon, Double> getBangDiem() { return bangDiem; }

    @Override
    public String toString() {
        return maSV + ", " + hoDem + " " + ten + ", " + ngaySinh + ", " + queQuan;
    }
    
    public double tinhTBchungHK(int kyThu) {
        if (bangDiem.isEmpty())
            return 0;
        
        double tongDiem = 0;
        int tongSoTC = 0;
        
        for (Mon mon : bangDiem.keys()) {
            if (mon.getKyThu() == kyThu) {
                double diem = bangDiem.get(mon);
                tongDiem += diem * mon.getSoTC();
                tongSoTC += mon.getSoTC();
            }
        }
        
        if (tongSoTC == 0)
            return 0;
        
        return tongDiem / tongSoTC;
    }
}