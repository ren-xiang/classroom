package service;
import Dao.*;
import domain.ArrangeClassroom;
import domain.Arrangement;
import domain.Course;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class ArrangementService {
    public boolean deleteAllArrangement() {
        DeleteDao dao = new DeleteDao();
        return dao.deleteArrangement();
    }

    public boolean generateArrangement() {
        SearchDao searchDao = new SearchDao();
        List<ArrangeClassroom> arrangeClassroomList = searchDao.searchArraangeClassroom();
        List<Course> courseList = searchDao.selectCourse();
        courseList.sort(Comparator.comparingInt(o -> Integer.parseInt(o.getMinRequest())));
        arrangeClassroomList.sort(Comparator.comparingInt(o -> Integer.parseInt(o.getSnum())));
        List<Arrangement> result = new LinkedList<>();
        for (Course course : courseList) {
            for (int i = 0; i < arrangeClassroomList.size(); i++) {
                ArrangeClassroom classroom = arrangeClassroomList.get(i);
                if (Integer.parseInt(classroom.getSnum()) >= Integer.parseInt(course.getMinRequest())) {
                    if (course.getType().equals(classroom.getType())) {
                        Arrangement arrangement = new Arrangement();
                        arrangement.setCid(course.getCid());
                        arrangement.setClassroomID(classroom.getClassroomID());
                        arrangement.setTeacherID(course.getTeacherID());
                        arrangement.setStatus("使用");
                        arrangement.setWeek("1");
                        arrangement.setWeekDay(classroom.getWeekDay());
                        arrangement.setSession(classroom.getSession());
                        arrangeClassroomList.remove(classroom);
                        result.add(arrangement);
                        break;
                    }
                }
            }
        }
        return new InsertDao().insertArrangementByProduce(result);
    }
}
