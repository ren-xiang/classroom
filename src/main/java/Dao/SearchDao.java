package Dao;

import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;
import  domain.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SearchDao {
    JdbcTemplate jdbcTemplate=new JdbcTemplate(JDBCUtils.getDataSource());
    //根据教师id查询其上课表
    public List<Teacherclass> searchClassByTID(String teacherID){
        String sql="select * from teacherclass where teacherID = ? ";
        List<Teacherclass> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Teacherclass>(Teacherclass.class), teacherID);
        return list;
    }
   /* //查询空闲教室
    public List<Classroom> searchFreeClassroom(){
        String sql="select classroomID,snum,type,week,weekDay,session from status_view where status is null";
        List<Classroom> list=jdbcTemplate.query(sql,new BeanPropertyRowMapper<Classroom>(Classroom.class));
        return list;
    }*/
    //查询符合要求的教室
    public List<Classroom> searchClassroom(String snum,String type){
        String sql="select * from status_view where status is NULL snum>=? and type=?";
        List<Classroom> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Classroom>(Classroom.class), snum, type);
        return list;
    }
    //查询教室状态
    public List<NewClassroom> searchClassroomStatus(Map<String,String> map,int start, int pageSize){
        String sql="select * from classroom_status where 1=1 ";
        StringBuilder sb=new StringBuilder(sql);
        List params=new ArrayList();
        for (String s : map.keySet()) {
            sb.append(" and "+s+" like ? ");
            params.add("%"+map.get(s)+"%");
        }
        sb.append(" limit ? , ? ");
        String sb_sql=sb.toString();
        System.out.println(sb_sql);
        params.add(start);
        params.add(pageSize);
        List<NewClassroom> list = jdbcTemplate.query(sb_sql, new BeanPropertyRowMapper<>(NewClassroom.class), params.toArray());
        return list;
    }
    //按条件查询符合要求的空闲教室
    public List<Classroom> selectFreeClassroomByCondition(Map<String,String> map,int start, int pageSize){
        String sql="select * from status_view where 1=1 ";
        StringBuilder sb=new StringBuilder(sql);
        List params=new ArrayList();
        for (String s : map.keySet()) {
            if(s.equals("minSize")){
                sb.append(" and snum>="+map.get(s)+" ");
                continue;
            }
            sb.append(" and "+s+" like ? ");
            params.add("%"+map.get(s)+"%");
        }
        sb.append(" limit ? , ? ");
        String sb_sql=sb.toString();
        System.out.println(sb_sql);
        params.add(start);
        params.add(pageSize);
        List<Classroom> list = jdbcTemplate.query(sb_sql, new BeanPropertyRowMapper<>(Classroom.class), params.toArray());
        return list;
    }
        
}
