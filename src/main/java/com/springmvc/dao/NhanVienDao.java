package com.springmvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.springmvc.beans.NhanVien;
@Repository
public class NhanVienDao {
	@Autowired
    private JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    // Thêm nhân viên mới
    public int save(NhanVien nv) {
        String sql = "INSERT INTO LTKD_NhanVien (ltkd_ho_ten, ltkd_email, ltkd_mat_khau, ltkd_chuc_vu, ltkd_luong, ltkd_ngay_vao_lam) "
                   + "VALUES (?, ?, ?, ?, ?, ?)";
        return template.update(sql, nv.getHoTen(), nv.getEmail(), nv.getMatKhau(), 
                               nv.getChucVu(), nv.getLuong(), nv.getNgayVaoLam());
    }

    // Cập nhật thông tin nhân viên
    public int update(NhanVien nv) {
        String sql = "UPDATE LTKD_NhanVien SET ltkd_ho_ten=?, ltkd_email=?, ltkd_mat_khau=?, ltkd_chuc_vu=?, ltkd_luong=?, ltkd_ngay_vao_lam=? "
                   + "WHERE ltkd_id=?";
        return template.update(sql, nv.getHoTen(), nv.getEmail(), nv.getMatKhau(), 
                               nv.getChucVu(), nv.getLuong(), nv.getNgayVaoLam(), nv.getId());
    }

    // Xóa nhân viên
    public int delete(int id) {
        String sql = "DELETE FROM LTKD_NhanVien WHERE ltkd_id=?";
        return template.update(sql, id);
    }

    // Lấy thông tin nhân viên theo ID
    public NhanVien getNhanVienById(int id) {
        String sql = "SELECT * FROM LTKD_NhanVien WHERE ltkd_id=?";
        return template.queryForObject(sql, new Object[] { id }, new BeanPropertyRowMapper<>(NhanVien.class));
    }

    // Lấy danh sách tất cả nhân viên
    public List<NhanVien> getAllNhanVien() {
        return template.query("SELECT * FROM LTKD_NhanVien", new RowMapper<NhanVien>() {
            public NhanVien mapRow(ResultSet rs, int rowNum) throws SQLException {
                NhanVien nv = new NhanVien();
                nv.setId(rs.getInt("ltkd_id"));
                nv.setHoTen(rs.getString("ltkd_ho_ten"));
                nv.setEmail(rs.getString("ltkd_email"));
                nv.setMatKhau(rs.getString("ltkd_mat_khau"));
                nv.setChucVu(rs.getString("ltkd_chuc_vu"));
                nv.setLuong(rs.getBigDecimal("ltkd_luong"));
                nv.setNgayVaoLam(rs.getDate("ltkd_ngay_vao_lam"));
                return nv;
            }
        });
    }
}
