package com.epam.news.dao;

import com.epam.news.model.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class JdbcNewsDAOImpl implements NewsDAO {
    public static final String SELECT_ALL = "SELECT * FROM news";
    public static final String UPDATE_RECORD = "UPDATE news SET title=?, brief=? where id=?";
    public static final String DELETE_RECORD = "DELETE FROM users WHERE id=?";
    public static final String SELECT_RECORD = "SELECT * FROM news WHERE id = ?";

    private final DataSource dataSource;
    private final JdbcTemplate jdbcTemplate;
    private final SimpleJdbcInsert insertNews;

    @Autowired
    public JdbcNewsDAOImpl(DataSource dataSource, JdbcTemplate jdbcTemplate) {
        this.dataSource = dataSource;
        this.jdbcTemplate = jdbcTemplate;
        this.insertNews = new SimpleJdbcInsert(dataSource)
                .withTableName("news")
                .usingGeneratedKeyColumns("id");
    }

    @Override
    public News create(News news) {
        MapSqlParameterSource map = new MapSqlParameterSource()
                .addValue("id", news.getId())
                .addValue("date", news.getDate())
                .addValue("title", news.getTitle())
                .addValue("brief", news.getBrief());
        Number newKey = insertNews.executeAndReturnKey(map);
        news.setId(newKey.intValue());

        return news;
    }

    @Override
    public News update(News news) {
        jdbcTemplate.update(UPDATE_RECORD, news.getTitle(), news.getBrief(), news.getId());
        return news;
    }

    @Override
    public boolean delete(int id) {
        return jdbcTemplate.update(DELETE_RECORD, id) != 0;
    }

    @Override
    public News get(int id) {
        List<News> news = jdbcTemplate.query(
                SELECT_RECORD,
                (rs, rowNum) ->
                        new News(
                                rs.getInt("id"),
                                rs.getTimestamp("date").toLocalDateTime().toLocalDate(),
                                rs.getString("title"),
                                rs.getString("brief"),
                                rs.getString("checked")
                        )
        );
        return DataAccessUtils.singleResult(news);
    }

    @Override
    public List<News> getAll() {
        List<News> list = jdbcTemplate.query(
                SELECT_ALL,
                (rs, rowNum) ->
                    new News(
                            rs.getInt("id"),
                            rs.getTimestamp("date").toLocalDateTime().toLocalDate(),
                            rs.getString("title"),
                            rs.getString("brief"),
                            rs.getString("checked")
                    )
        );
        return list;
    }
}
