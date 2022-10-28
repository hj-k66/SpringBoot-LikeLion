package com.example.springboothello.dao;

import com.example.springboothello.domain.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class UserDao {
    private final JdbcTemplate jdbcTemplate;

    public UserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void add(User user){
        this.jdbcTemplate.update("INSERT INTO users(id,name,password) values(?,?,?)",
                user.getId(), user.getName(), user.getPassword());
    }

    public void deleteAll(){
        this.jdbcTemplate.update("DELETE FROM users");
    }

    RowMapper<User> rowMapper = new RowMapper<User>() {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User(rs.getString("id"), rs.getString("name"), rs.getString("password"));
            return user;
        }
    };
    public User getById(String id){

        return this.jdbcTemplate.queryForObject("SELECT * FROM users where id = ?", rowMapper);
    }


    public void deleteById(String id){
        this.jdbcTemplate.update("DELETE * from users where id = ?", id);
    }

}
