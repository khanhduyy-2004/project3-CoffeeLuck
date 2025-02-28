package com.springmvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.springmvc.beans.User;

public class UserDao {
    private JdbcTemplate jdbcTemplate;

    // Set DataSource
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Lấy danh sách người dùng
    public List<User> getUsers() {
        String sql = "SELECT * FROM LTKD_NguoiDung";
        return jdbcTemplate.query(sql, new RowMapper<User>() {
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new User(rs.getInt("ltkd_id"), rs.getString("ltkd_ho_ten"), rs.getString("ltkd_email"));
            }
        });
    }
}
