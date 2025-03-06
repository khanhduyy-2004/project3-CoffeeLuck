package com.springmvc.beans;

import java.math.BigDecimal;

public class ChiTietDonHang {
    private int id;
    private int donHangId;
    private int sanPhamId;
    private int soLuong;
    private BigDecimal gia;

    public ChiTietDonHang() {}

    public ChiTietDonHang(int donHangId, int sanPhamId, int soLuong, BigDecimal gia) {
        this.donHangId = donHangId;
        this.sanPhamId = sanPhamId;
        this.soLuong = soLuong;
        this.gia = gia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDonHangId() {
        return donHangId;
    }

    public void setDonHangId(int donHangId) {
        this.donHangId = donHangId;
    }

    public int getSanPhamId() {
        return sanPhamId;
    }

    public void
