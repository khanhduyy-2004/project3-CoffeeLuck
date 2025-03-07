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

    public int save(NguoiDung nd) {
        String sql = "INSERT INTO LTKD_NguoiDung (ltkd_tai_khoan, ltkd_mat_khau, ltkd_email) VALUES (?, ?, ?)";
        return template.update(sql, nd.getHoTen(), nd.getMatKhau(), nd.getEmail());
    }

    public int update(NguoiDung nd) {
        String sql = "UPDATE LTKD_NguoiDung SET ltkd_tai_khoan=?, ltkd_mat_khau=?, ltkd_email=? WHERE ltkd_id=?";
        return template.update(sql, nd.getHoTen(), nd.getMatKhau(), nd.getEmail(), nd.getId());
    }

    public int delete(int id) {
        String sql = "DELETE FROM LTKD_NguoiDung WHERE ltkd_id=?";
        return template.update(sql, id);
    }

    public NguoiDung getNguoiDungById(int id) {
        String sql = "SELECT * FROM LTKD_NguoiDung WHERE ltkd_id=?";
        return template.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(NguoiDung.class));
    }

    public List<NguoiDung> getAllNguoiDung() {
        return template.query("SELECT * FROM LTKD_NguoiDung", new RowMapper<NguoiDung>() {
            public NguoiDung mapRow(ResultSet rs, int rowNum) throws SQLException {
                NguoiDung nd = new NguoiDung();
                nd.setId(rs.getInt("ltkd_id"));
                nd.setHoTen(rs.getString("ltkd_ho_ten"));
                nd.setMatKhau(rs.getString("ltkd_mat_khau"));
                nd.setEmail(rs.getString("ltkd_email"));
                return nd;
            }
        });
    }
}
