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
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 预约符合要求的教室
 */
@WebServlet("/selectFreeClassroom")
public class SelectFreeClassroomServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO test
        Map<String, String[]> map = request.getParameterMap();
        Map<String, String> myMap = new HashMap<>();
        for (String key : map.keySet()) {
            if (key.equals("start") || key.equals("pageSize")) {
                continue;
            }
            myMap.put(key, map.get(key)[0]);
        }
        ClassroomService service = new ClassroomService();
        List<Classroom> result = service.getClassroomListBy(myMap, start, pageSize);
        ObjectMapper mapper = new ObjectMapper();
        String resultJs = null;
        try {
            result = mapper.writeValueAsString(result);
        } catch (Exception e) {
            resultJs = "[]";
            e.printStackTrace();
        }
        try (PrintWriter out = response.getWriter()) {
            out.write(resultJs);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
