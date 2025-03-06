package com.springmvc.dao;

import com.springmvc.beans.DanhMuc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class DanhMucDao {

    @Autowired
    private JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    // Thêm danh mục mới
    public int save(DanhMuc dm) {
        String sql = "INSERT INTO LTKD_DanhMuc (ltkd_ten_danh_muc) VALUES (?)";
        return template.update(sql, dm.getTenDanhMuc());
    }

    // Cập nhật danh mục
    public int update(DanhMuc dm) {
        String sql = "UPDATE LTKD_DanhMuc SET ltkd_ten_danh_muc=? WHERE ltkd_id=?";
        return template.update(sql, dm.getTenDanhMuc(), dm.getId());
    }

    // Xóa danh mục
    public int delete(int id) {
        String sql = "DELETE FROM LTKD_DanhMuc WHERE ltkd_id=?";
        return template.update(sql, id);
    }

    // Lấy danh mục theo ID
    public DanhMuc getDanhMucById(int id) {
        String sql = "SELECT * FROM LTKD_DanhMuc WHERE ltkd_id=?";
        return template.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(DanhMuc.class));
    }

    // Lấy danh sách danh mục
    public List<DanhMuc> getAllDanhMuc() {
        return template.query("SELECT * FROM LTKD_DanhMuc", new RowMapper<DanhMuc>() {
            public DanhMuc mapRow(ResultSet rs, int rowNum) throws SQLException {
                DanhMuc dm = new DanhMuc();
                dm.setId(rs.getInt("ltkd_id"));
                dm.setTenDanhMuc(rs.getString("ltkd_ten_danh_muc"));
                return dm;
            }
        });
    }
}
