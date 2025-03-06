package com.springmvc.beans;

import java.math.BigDecimal;
import java.util.Date;

public class DonHang {
    private int id;
    private int nguoiDungId;
    private Date ngayDat;
    private BigDecimal tongTien;
    private int trangThai;

    public DonHang() {}

    public DonHang(int nguoiDungId, Date ngayDat, BigDecimal tongTien, int trangThai) {
        this.nguoiDungId = nguoiDungId;
        this.ngayDat = ngayDat;
        this.tongTien = tongTien;
        this.trangThai = trangThai;
    }

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
        this.n
