package Dao;

import domain.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

public class loginDao {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
    public User login(User user){
        User ReturnUser=null;
        try {
            String sql="select * from User where teacherID=? and password=?";
            ReturnUser = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), user.getTeacherID(), user.getPassword());
        }catch (Exception e){
            e.printStackTrace();
        }
        return ReturnUser;
    }
    
}
