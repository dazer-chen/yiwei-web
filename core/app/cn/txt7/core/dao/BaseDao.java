package cn.txt7.core.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import javax.sql.DataSource;

public abstract class BaseDao<T> implements ParameterizedRowMapper<T> {
    private final static String SEP = "_";

    public String tableName;
    public int shards;
    public JdbcTemplate jdbcTemplate;


    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public void setShards(int shards) {
        this.shards = shards;
    }

    public String getTable(long id) {
        return tableName + SEP + id % shards;
    }
}
