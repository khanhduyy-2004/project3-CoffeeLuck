package com.springmvc.beans;

import java.math.BigDecimal;

public class SanPham {
    private int id;
    private String tenSanPham;
    private String moTa;
    private BigDecimal gia;
    private String hinhAnh;
    private int danhMucId;

    public SanPham() {}

    public SanPham(String tenSanPham, String moTa, BigDecimal gia, String hinhAnh, int danhMucId) {
        this.tenSanPham = tenSanPham;
        this.moTa = moTa;
        this.gia = gia;
        this.hinhAnh = hinhAnh;
        this.danhMucId = danhMucId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public BigDecimal getGia() {
        return gia;
    }

    public void setGia(BigDecimal gia) {
        this.gia = gia;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public int getDanhMucId() {
        return danhMucId;
    }

    public void setDanhMucId(int danhMucId) {
        this.danhMucId = danhMucId;
    }
}
