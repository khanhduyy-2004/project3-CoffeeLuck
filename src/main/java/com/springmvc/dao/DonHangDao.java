package com.springmvc.dao;

import com.springmvc.beans.DonHang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class DonHangDao {

    @Autowired
    private JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    // Thêm đơn hàng mới
    public int save(DonHang dh) {
        String sql = "INSERT INTO LTKD_DonHang (ltkd_nguoi_dung_id, ltkd_ngay_dat, ltkd_tong_tien, ltkd_trang_thai) "
                   + "VALUES (?, ?, ?, ?)";
        return template.update(sql, dh.getNguoiDungId(), dh.getNgayDat(), dh.getTongTien(), dh.getTrangThai());
    }

    // Cập nhật đơn hàng
    public int update(DonHang dh) {
        String sql = "UPDATE LTKD_DonHang SET ltkd_nguoi_dung_id=?, ltkd_ngay_dat=?, ltkd_tong_tien=?, ltkd_trang_thai=? "
                   + "WHERE ltkd_id=?";
        return template.update(sql, dh.getNguoiDungId(), dh.getNgayDat(), dh.getTongTien(), dh.getTrangThai(), dh.getId());
    }

    // Xóa đơn hàng
    public int delete(int id) {
        String sql = "DELETE FROM LTKD_DonHang WHERE ltkd_id=?";
        return template.update(sql, id);
    }

    // Lấy thông tin đơn hàng theo ID
    public DonHang getDonHangById(int id) {
        String sql = "SELECT * FROM LTKD_DonHang WHERE ltkd_id=?";
        return template.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(DonHang.class));
    }

    // Lấy danh sách tất cả đơn hàng
    public List<DonHang> getAllDonHang() {
        return template.query("SELECT * FROM LTKD_DonHang", new RowMapper<DonHang>() {
            public DonHang mapRow(ResultSet rs, int rowNum) throws SQLException {
                DonHang dh = new DonHang();
                dh.setId(rs.getInt("ltkd_id"));
                dh.setNguoiDungId(rs.getInt("ltkd_nguoi_dung_id"));
                dh.setNgayDat(rs.getDate("ltkd_ngay_dat"));
                dh.setTongTien(rs.getBigDecimal("ltkd_tong_tien"));
                dh.setTrangThai(rs.getString("ltkd_trang_thai"));
                return dh;
            }
        });
    }
}
