package com.springmvc.beans;

import java.math.BigDecimal;
import java.util.Date;

public class DonHang {
    private int id;
    private int nguoiDungId;
    private Date ngayDat;
    private BigDecimal tongTien;
    private int trangThai;

    // Constructors
    public DonHang() {
        super();
    }

    public DonHang(int nguoiDungId, Date ngayDat, BigDecimal tongTien, int trangThai) {
        this.nguoiDungId = nguoiDungId;
        this.ngayDat = ngayDat;
        this.tongTien = tongTien;
        this.trangThai = trangThai;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNguoiDungId() {
        return nguoiDungId;
    }

    public void setNguoiDungId(int nguoiDungId) {
        this.nguoiDungId = nguoiDungId;
    }

    public Date getNgayDat() {
        return ngayDat;
    }

    public void setNgayDat(Date ngayDat) {
        this.ngayDat = ngayDat;
    }

    public BigDecimal getTongTien() {
        return tongTien;
    }

    public void setTongTien(BigDecimal tongTien) {
        this.tongTien = tongTien;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
}
