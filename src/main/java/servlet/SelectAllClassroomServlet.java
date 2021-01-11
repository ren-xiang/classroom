package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import service.ClassroomService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import domain.NewClassroom;

import java.util.List;
import java.util.Map;


/**
 * 查询所有教室情况
 */
@WebServlet("/selectAllClassroom")
public class SelectAllClassroomServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String> myMap = new HashMap<>();
        Map<String, String[]> map = req.getParameterMap();
        for (String key : map.keySet()) {
            if (key.equals("start") || key.equals("pageSize")) {
                continue;
            }
            myMap.put(key, map.get(key)[0]);
        }
        ClassroomService service = new ClassroomService();
        int start = Integer.parseInt(req.getParameter("start"));
        int pageSize = Integer.parseInt(req.getParameter("pageSize"));
        List<NewClassroom> list = service.selectAllClassroom(myMap, start, pageSize);
        ObjectMapper mapper = new ObjectMapper();
        resp.setContentType("application/json;charset=utf-8");
        mapper.writeValue(resp.getOutputStream(), list);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
