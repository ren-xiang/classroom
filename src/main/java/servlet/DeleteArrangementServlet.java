package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Arrangement;
import service.ArrangementService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * 删除安排表
 */
@WebServlet("/deleteArrangement")
public class DeleteArrangementServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrangementService service = new ArrangementService();
        boolean isSuccess = service.deleteAllArrangement();
        ObjectMapper mapper = new ObjectMapper();
        resp.setContentType("application/json;charset=utf-8");
        mapper.writeValue(resp.getOutputStream(), isSuccess);
    }
}
