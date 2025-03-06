package com.springmvc.beans;

import java.math.BigDecimal;
import java.util.Date;

public class NhanVien {
    private int id;
    private String hoTen;
    private String email;
    private String matKhau;
    private String chucVu;
    private BigDecimal luong;
    private Date ngayVaoLam;

    // Constructors
    public NhanVien() {
        super();
    }

    public NhanVien(String hoTen, String email, String matKhau, String chucVu, BigDecimal luong, Date ngayVaoLam) {
        super();
        this.hoTen = hoTen;
        this.email = email;
        this.matKhau = matKhau;
        this.chucVu = chucVu;
        this.luong = luong;
        this.ngayVaoLam = ngayVaoLam;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public BigDecimal getLuong() {
        return luong;
    }

    public void setLuong(BigDecimal bigDecimal) {
        this.luong = bigDecimal;
    }

    public Date getNgayVaoLam() {
        return ngayVaoLam;
    }

    public void setNgayVaoLam(Date ngayVaoLam) {
        this.ngayVaoLam = ngayVaoLam;
    }
}