package com.springmvc.dao;

import com.springmvc.beans.SanPham;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class SanPhamDao {

    @Autowired
    private JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    // Thêm sản phẩm
    public int save(SanPham sp) {
        String sql = "INSERT INTO LTKD_SanPham (ltkd_ten_san_pham, ltkd_gia, ltkd_mo_ta, ltkd_danh_muc_id) VALUES (?, ?, ?, ?)";
        return template.update(sql, sp.getTenSanPham(), sp.getGia(), sp.getMoTa(), sp.getDanhMucId());
    }

    // Cập nhật sản phẩm
    public int update(SanPham sp) {
        String sql = "UPDATE LTKD_SanPham SET ltkd_ten_san_pham=?, ltkd_gia=?, ltkd_mo_ta=?, ltkd_danh_muc_id=? WHERE ltkd_id=?";
        return template.update(sql, sp.getTenSanPham(), sp.getGia(), sp.getMoTa(), sp.getDanhMucId(), sp.getId());
    }

    // Xóa sản phẩm
    public int delete(int id) {
        String sql = "DELETE FROM LTKD_SanPham WHERE ltkd_id=?";
        return template.update(sql, id);
    }

    // Lấy sản phẩm theo ID
    public SanPham getSanPhamById(int id) {
        String sql = "SELECT * FROM LTKD_SanPham WHERE ltkd_id=?";
        return template.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(SanPham.class));
    }

    // Lấy danh sách sản phẩm
    public List<SanPham> getAllSanPham() {
        return template.query("SELECT * FROM LTKD_SanPham", new RowMapper<SanPham>() {
            public SanPham mapRow(ResultSet rs, int rowNum) throws SQLException {
                SanPham sp = new SanPham();
                sp.setId(rs.getInt("ltkd_id"));
                sp.setTenSanPham(rs.getString("ltkd_ten_san_pham"));
                sp.setGia(rs.getBigDecimal("ltkd_gia"));
                sp.setMoTa(rs.getString("ltkd_mo_ta"));
                sp.setDanhMucId(rs.getInt("ltkd_danh_muc_id"));
                return sp;
            }
        });
    }
}
