package service;

import Dao.InsertDao;
import Dao.SearchDao;
import domain.Arrangement;
import domain.Classroom;
import domain.User;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

public class ClassroomService {
    public List<Classroom> getClassroomListBy(Map<String, String> map, int start, int pageSize) {
        SearchDao searchDao = new SearchDao();
        return searchDao.selectFreeClassroomByCondition(map, start, pageSize);
    }

    public boolean addOrderBy(Map<String, String> map) {
        InsertDao insertDao = new InsertDao();
        Arrangement arrangement = new Arrangement();
        try {
            BeanUtils.populate(arrangement, map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return insertDao.insertArrangement(arrangement);
    }
}
