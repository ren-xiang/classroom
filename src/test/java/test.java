import Dao.*;

import domain.Arrangement;
import domain.Classroom;

import domain.NewClassroom;
import domain.User;
import domain.Teacherclass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test {
    SearchDao searchDao=new SearchDao();
    InsertDao insertDao=new InsertDao();
    
    @Test
    public void testClassroom(){
        List<Classroom> list = searchDao.searchClassroom("40", "多媒体教室");
        System.out.println(list);
    }
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
       DeleteDao deleteDao=new DeleteDao();
       System.out.println(deleteDao.deleteArrangement()); 
   }
}
