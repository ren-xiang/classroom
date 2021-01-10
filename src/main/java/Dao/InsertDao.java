package Dao;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;
import domain.Arrangement;

import java.util.List;

public class InsertDao {
    JdbcTemplate jdbcTemplate=new JdbcTemplate(JDBCUtils.getDataSource());
    
    public boolean insertArrangement(Arrangement arrangement){
        String sql="insert into arrangement values(?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql,arrangement.getClassroomID(),arrangement.getCid(),arrangement.getTeacherID(),
                arrangement.getStatus(),arrangement.getWeek(),arrangement.getWeekDay(),arrangement.getSession());
        return true;
    }

    public boolean insertArrangement(List<Object[]> list){
        String sql="insert into arrangement values(?,?,?,?,?,?,?)";
        jdbcTemplate.batchUpdate(sql, list);
        return true;
    }
}
