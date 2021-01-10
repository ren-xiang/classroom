package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.User;
import service.ClassroomService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 添加预约
 */
@WebServlet("/addOrder")
public class AddOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String> map = new HashMap<>();
        Map<String, String[]> parameterMap = req.getParameterMap();
        for (String key : parameterMap.keySet()) {
            map.put(key, parameterMap.get(key)[0]);
            System.out.println(key+":"+parameterMap.get(key)[0]);
        }
        map.put("teacherID", ((User) req.getSession().getAttribute("user")).getTeacherID());
        ClassroomService service = new ClassroomService();
        boolean isSuccess = service.addOrderBy(map);
        ObjectMapper mapper = new ObjectMapper();
        resp.setContentType("application/json;charset=utf-8");
        mapper.writeValue(resp.getOutputStream(), isSuccess);
    }
}
