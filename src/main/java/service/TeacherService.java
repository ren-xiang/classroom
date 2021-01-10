package service;

import Dao.SearchDao;
import domain.Teacherclass;

import java.util.List;

public class TeacherService {
    public List<Teacherclass> searchJobService(String teacherID) {
        SearchDao dao = new SearchDao();
        return dao.searchClassByTID(teacherID);
    }
}
