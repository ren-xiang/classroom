import Dao.*;

import domain.*;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test {
    SearchDao searchDao=new SearchDao();
    InsertDao insertDao=new InsertDao();
    
    
    @Test
    public void testClassroomStatus(){
        Map<String,String> map=new HashMap<String, String>();
        map.put("classroomID","教一101");
       /* map.put("week","2");
        map.put("weekDay","星期1");
        map.put("session","1");*/
        List<NewClassroom> newClassrooms = searchDao.searchClassroomStatus(map, 0, 5);
        System.out.println(newClassrooms);
    }
   /* @Test
    public void testUpdate(){
        String[] arrangement={"教一101","TMP6669","00001222","使用","1","星期2","3,4"};
        String[] arrangement1={"教一101","TMP6667","00001223","使用","1","星期2","5,6"};
        String[] arrangement2={"教一101","TMP6668","00001224","使用","1","星期3","1,2"};
     
        List<Object[]> list=new ArrayList<>();
        list.add(arrangement);
        list.add(arrangement1);
        list.add(arrangement2);
        *//*insertDao.insertArrangement(arrangement);*//*
        insertDao.insertArrangement(list);
    }*/
   @Test
   public void testFreeClassroomStatus(){
       Map<String,String> map=new HashMap<String, String>();
       map.put("minSize","50");
       map.put("type","多媒体教室");
       map.put("week","2");
       map.put("weekDay","星期1");
       map.put("session","1");
       List<Classroom> classrooms = searchDao.selectFreeClassroomByCondition(map, 0, 5);
       System.out.println(classrooms);
   }
   @Test
   public void testDelete(){
       JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
       for (int week = 1; week <= 18; week++) {
           for (int weekDay = 1; weekDay < 6; weekDay++) {
               for (int session = 0; session <= 4; session += 2) {
                   String sql = "insert into Time values(?,?,?)";
                   jdbcTemplate.update(sql, week, "星期" + weekDay, "" + (session + 1) + "-" + (session + 2));
               }
           }
       } 
   }

    @Test
    public void testSearch(){
       Arrangement arrangement=new Arrangement("教一101","TMP6666","00001442","使用","1","星期1","1-2");
       Arrangement arrangement2=new Arrangement("教一101","TMP6667","00001442","使用","1","星期1","3-4");
       List<Arrangement> list=new ArrayList<>();
       list.add(arrangement);
       list.add(arrangement2);
        boolean b = insertDao.insertArrangementByProduce(list);
        System.out.println(b);
       /*List<Course> list = searchDao.selectCourse();
        System.out.println(list);*/
       /* List<ArrangeClassroom> arrangeClassrooms = searchDao.searchArraangeClassroom();
        System.out.println(arrangeClassrooms);*/
       // JdbcTemplate jdbcTemplate=new JdbcTemplate(JDBCUtils.getDataSource());
       // System.out.println("call insert_arrangement(\"教一101\",\"TMP6666\",\"00001442\",\"使用\",\"1\",\"星期1\",\"1-2\")");
      //  System.out.println("call insert_arrangement("+"\""+arrangement.getClassroomID()+"\""+","+"\""+arrangement.getCid()+"\""+","+"\""+arrangement.getTeacherID()+"\""+","+"\""+arrangement.getStatus()+"\""+","+"\""+arrangement.getWeek()+"\""+","+"\""+arrangement.getWeekDay()+"\""+","+"\""+arrangement.getSession()+"\""+")");
      //  jdbcTemplate.execute("call insert_arrangement("+"\""+arrangement.getClassroomID()+"\""+","+"\""+arrangement.getCid()+"\""+","+"\""+arrangement.getTeacherID()+"\""+","+"\""+arrangement.getStatus()+"\""+","+"\""+arrangement.getWeek()+"\""+","+"\""+arrangement.getWeekDay()+"\""+","+"\""+arrangement.getSession()+"\""+")");
       //arrangement.getClassroomID()+","+arrangement.getCid()+","+arrangement.getTeacherID()+","+arrangement.getStatus()+","+arrangement.getWeek()+","+arrangement.getWeekDay()+","+arrangement.getSession()+")");
       
        //jdbcTemplate.execute("call insert_arrangement(\"教一101\",\"TMP6666\",\"00001442\",\"使用\",\"1\",\"星期1\",\"1-2\")");
    }
   
}
