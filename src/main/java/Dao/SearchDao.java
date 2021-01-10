package Dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;
import  domain.*;
import java.util.List;

public class SearchDao {
    JdbcTemplate jdbcTemplate=new JdbcTemplate(JDBCUtils.getDataSource());
    
    public List<teacherclass> SearchClassByTID(String teacherID){
        String sql="select * from teacherclass where teacherID = ? ";
        List<teacherclass> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<teacherclass>(teacherclass.class), teacherID);
        return list;
    }
    public List<FreeClassroom> SearchFreeClassroom(){
        String sql="select classroomID,snum,type,week,weekDay,session from status_view where status is null";
        List<FreeClassroom> list=jdbcTemplate.query(sql,new BeanPropertyRowMapper<FreeClassroom>(FreeClassroom.class));
        return list;
    }
    
}
