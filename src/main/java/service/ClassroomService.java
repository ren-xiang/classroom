package service;

import Dao.SearchDao;
import domain.Classroom;

import java.util.List;
import java.util.Map;

public class ClassroomService {
    public List<Classroom> getClassroomListBy(Map<String, String> map, String start, String pageSize) {
        SearchDao searchDao = new SearchDao();
        return searchDao.searchClassroom(map, start, pageSize);
    }
}
