package cn.txt7.core.dao;

import cn.txt7.core.dao.model.Article;
import org.springframework.jdbc.core.PreparedStatementCreator;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.sql.*;
import java.util.List;

/**
 * article dao
 * User: shijinkui
 * Date: 13-10-8
 * Time: 下午9:36
 * To change this template use File | Settings | File Templates.
 */
public class ArticleDao extends BaseDao<Article> {
    private final String fmt_insert = "INSERT INTO " + tableName + " (author, head, content, tag, category, ctime) " +
            "VALUES (?, ?, ? ,?, ?, CURRENT_TIMESTAMP)";
    private final String fmt_get = "select * from " + tableName + " where id=%d";
    private final String fmt_getNext = "select * from " + tableName + " where id<%d order by id desc limit %d";
    private final String fmt_getPre = "select * from " + tableName + " where id>%d order by id desc limit %d";
    private final String all_count = "select count(id) from " + tableName;

    public boolean create(final Article dto) {

        int ret = jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(fmt_insert, PreparedStatement.RETURN_GENERATED_KEYS);
                ps.setString(1, dto.getAuthor());
                ps.setString(2, dto.getHead());
                ps.setString(3, dto.getContent());
                ps.setString(4, dto.getTag());
                ps.setString(5, dto.getCategory());

                return ps;
            }
        });

        return ret > 0;
    }

    public Article getById(long id) {
        Article ret = jdbcTemplate.queryForObject(String.format(fmt_get, id), this);
        return ret;
    }

    public List<Article> getNextByCursor(long next_cursor, int limit) {
        List<Article> ret = jdbcTemplate.query(String.format(fmt_getNext, next_cursor, limit), this);

        return ret;
    }

    public List<Article> getPreByCursor(long pre_cursor, int limit) {
        List<Article> ret = jdbcTemplate.query(String.format(fmt_getPre, pre_cursor, limit), this);

        return ret;
    }

    public int getSum() {
        return jdbcTemplate.queryForObject(all_count, Integer.class);
    }

    @Override
    public Article mapRow(ResultSet r, int i) throws SQLException {
        Article dto = new Article();
        dto.setId(r.getLong("id"));
        dto.setAuthor(r.getString("author"));
        dto.setHead(r.getString("head"));
        dto.setContent(convertBlobToString(r.getBlob("content")));
        dto.setEditor(r.getInt("editor"));
        dto.setTag(r.getString("tag"));
        dto.setCtime(r.getTimestamp("ctime"));
        dto.setUptime(r.getTimestamp("uptime"));
        dto.setCategory(r.getString("category"));
        dto.setShotname(r.getString("shortname"));
        dto.setMedianame(r.getString("medianame"));

        return dto;
    }

    private String convertBlobToString(Blob blob) {

        String result = "";
        try {
            ByteArrayInputStream stream = (ByteArrayInputStream) blob.getBinaryStream();
            byte[] bytes = new byte[stream.available()];
            stream.read(bytes, 0, bytes.length);
            result = new String(bytes, Charset.defaultCharset());
            stream.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}
