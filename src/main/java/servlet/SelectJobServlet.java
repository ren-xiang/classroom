package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Teacherclass;
import domain.User;
import service.TeacherService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 查询本人上课任务
 */
@WebServlet("/selectJob")
public class SelectJobServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String teacherID = ((User) request.getSession().getAttribute("user")).getTeacherID();
        TeacherService service = new TeacherService();
        List<Teacherclass> classList = service.searchJobService(teacherID);
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(), classList);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
