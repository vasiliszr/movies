package com.aueb.movies.dao;

import com.aueb.movies.model.Bookmarks;
import com.aueb.movies.model.Users;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.List;

public class UsersDAOImpl implements UsersDAO {

    private JdbcTemplate jdbcTemplate;

    public UsersDAOImpl(DataSource ds) {
        this.jdbcTemplate = new JdbcTemplate(ds);
    }

    @Override
    public int register(Users users) {
        String sql = "INSERT INTO users(id, email, password) VALUES(?, ?, ?)";
        return jdbcTemplate.update(sql,  users.getId(), users.getEmail(), users.getPassword());
    }

    @Override
    public Users login(int id) {
        String sql = "SELECT * FROM users WHERE id = " + id;
        ResultSetExtractor<Users> ext = resultSet -> {
            if (resultSet.next()) {
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                return new Users(id, email, password);
            }
            return null;
        };
        return jdbcTemplate.query(sql, ext);
    }

    @Override
    public int saveBookmark(Bookmarks bookmarks) {
        String sql = "INSERT INTO bookmarks(id, movie_id) VALUES(?, ?)";
        return jdbcTemplate.update(sql, bookmarks.getId(), bookmarks.getMovie_id());
    }

    @Override
    public List<Bookmarks> getBookmarks(int id) {
        String sql = "SELECT movie_id FROM bookmarks WHERE bookmarks.id = " + id;
        RowMapper<Bookmarks> rowMapper = (resultSet, i) -> {
            int movie_id = resultSet.getInt("movie_id");
            return new Bookmarks(id, movie_id);
        };
        return jdbcTemplate.query(sql, rowMapper);
    }

}
