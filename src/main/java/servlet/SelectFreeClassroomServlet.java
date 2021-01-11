package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Classroom;
import service.ClassroomService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 查询符合要求的教室
 */
@WebServlet("/selectFreeClassroom")
public class SelectFreeClassroomServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> map = request.getParameterMap();
        Map<String, String> myMap = new HashMap<>();
        for (String key : map.keySet()) {
            if (key.equals("start") || key.equals("pageSize")) {
                continue;
            }
            myMap.put(key, URLDecoder.decode("UTF-8", map.get(key)[0]));
        }
        ClassroomService service = new ClassroomService();
        List<Classroom> result = service.getClassroomListBy(
                myMap, Integer.parseInt(map.get("start")[0]), Integer.parseInt(map.get("pageSize")[0]));
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(), result);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
