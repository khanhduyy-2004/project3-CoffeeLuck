package com.springmvc.dao;

import com.springmvc.beans.ChiTietDonHang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ChiTietDonHangDao {
    @Autowired
    private JdbcTemplate template;
    
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    // Thêm chi tiết đơn hàng mới	
    public int save(ChiTietDonHang ctdh) {
        String sql = "INSERT INTO LTKD_ChiTietDonHang (ltkd_don_hang_id, ltkd_san_pham_id, ltkd_so_luong, ltkd_gia) VALUES (?, ?, ?, ?)";
        return template.update(sql, ctdh.getDonHangId(), ctdh.getSanPhamId(), ctdh.getSoLuong(), ctdh.getGia());
    }

    // Cập nhật chi tiết đơn hàng
    public int update(ChiTietDonHang ctdh) {
        String sql = "UPDATE LTKD_ChiTietDonHang SET ltkd_so_luong=?, ltkd_gia=? WHERE ltkd_id=?";
        return template.update(sql, ctdh.getSoLuong(), ctdh.getGia(), ctdh.getId());
    }

    // Xóa chi tiết đơn hàng theo ID
    public int delete(int id) {
        String sql = "DELETE FROM LTKD_ChiTietDonHang WHERE ltkd_id=?";
        return template.update(sql, id);
    }

    // Lấy chi tiết đơn hàng theo ID
    public ChiTietDonHang getChiTietDonHangById(int id) {
        String sql = "SELECT * FROM LTKD_ChiTietDonHang WHERE ltkd_id=?";
        return template.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(ChiTietDonHang.class));
    }

    // Lấy danh sách chi tiết đơn hàng theo mã đơn hàng
    public List<ChiTietDonHang> getChiTietByDonHangId(int donHangId) {
        String sql = "SELECT * FROM LTKD_ChiTietDonHang WHERE ltkd_don_hang_id=?";
        return template.query(sql, new Object[]{donHangId}, new RowMapper<ChiTietDonHang>() {
            public ChiTietDonHang mapRow(ResultSet rs, int rowNum) throws SQLException {
                ChiTietDonHang ctdh = new ChiTietDonHang();
                ctdh.setId(rs.getInt("ltkd_id"));
                ctdh.setDonHangId(rs.getInt("ltkd_don_hang_id"));
                ctdh.setSanPhamId(rs.getInt("ltkd_san_pham_id"));
                ctdh.setSoLuong(rs.getInt("ltkd_so_luong"));
                ctdh.setGia(rs.getBigDecimal("ltkd_gia"));
                return ctdh;
            }
        });
    }

    // Lấy tất cả chi tiết đơn hàng
    public List<ChiTietDonHang> getAllChiTietDonHang() {
        return template.query("SELECT * FROM LTKD_ChiTietDonHang", new RowMapper<ChiTietDonHang>() {
            public ChiTietDonHang mapRow(ResultSet rs, int rowNum) throws SQLException {
                ChiTietDonHang ctdh = new ChiTietDonHang();
                ctdh.setId(rs.getInt("ltkd_id"));
                ctdh.setDonHangId(rs.getInt("ltkd_don_hang_id"));
                ctdh.setSanPhamId(rs.getInt("ltkd_san_pham_id"));
                ctdh.setSoLuong(rs.getInt("ltkd_so_luong"));
                ctdh.setGia(rs.getBigDecimal("ltkd_gia"));
                return ctdh;
            }
        });
    }
}
