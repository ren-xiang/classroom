package Dao;

import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

public class DeleteDao {
    JdbcTemplate jdbcTemplate=new JdbcTemplate(JDBCUtils.getDataSource());
    //清空安排表
    public boolean deleteArrangement(){
        String sql="delete  from arrangement";
        jdbcTemplate.update(sql);
        return true;
    }
}
