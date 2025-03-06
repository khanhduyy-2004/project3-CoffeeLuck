package com.springmvc.dao;

import com.springmvc.beans.NguoiDung;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class NguoiDungDao {

    @Autowired
    private JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    // Thêm người dùng
    public int save(NguoiDung nd) {
        String sql = "INSERT INTO LTKD_NguoiDung (ltkd_ten_dang_nhap, ltkd_mat_khau, ltkd_email) VALUES (?, ?, ?)";
        return template.update(sql, nd.getTenDangNhap(), nd.getMatKhau(), nd.getEmail());
    }

    // Cập nhật người dùng
    public int update(NguoiDung nd) {
        String sql = "UPDATE LTKD_NguoiDung SET ltkd_ten_dang_nhap=?, ltkd_mat_khau=?, ltkd_email=? WHERE ltkd_id=?";
        return template.update(sql, nd.getTenDangNhap(), nd.getMatKhau(), nd.getEmail(), nd.getId());
    }

    // Xóa người dùng
    public int delete(int id) {
        String sql = "DELETE FROM LTKD_NguoiDung WHERE ltkd_id=?";
        return template.update(sql, id);
    }

    // Lấy người dùng theo ID
    public NguoiDung getNguoiDungById(int id) {
        String sql = "SELECT * FROM LTKD_NguoiDung WHERE ltkd_id=?";
        return template.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(NguoiDung.class));
    }

    // Lấy danh sách người dùng
    public List<NguoiDung> getAllNguoiDung() {
        return template.query("SELECT * FROM LTKD_NguoiDung", new RowMapper<NguoiDung>() {
            public NguoiDung mapRow(ResultSet rs, int rowNum) throws SQLException {
                NguoiDung nd = new NguoiDung();
                nd.setId(rs.getInt("ltkd_id"));
                nd.setTenDangNhap(rs.getString("ltkd_ten_dang_nhap"));
                nd.setMatKhau(rs.getString("ltkd_mat_khau
