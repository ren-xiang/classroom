package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.ResultInfo;
import domain.User;
import org.apache.commons.beanutils.BeanUtils;
import service.loginService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResultInfo resultInfo=new ResultInfo();
        User user=new User();
        loginService loginService=new loginService();
        //        设置接收参数的编码
        request.setCharacterEncoding("utf8");
        Map<String, String[]> map = request.getParameterMap();
            try {
                BeanUtils.populate(user,map);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            System.out.println(user+"hhhh");
            User loginUser = loginService.login(user);
            if(loginUser!=null){
                resultInfo.setFlag(true);
                request.getSession().setAttribute("user",loginUser);
            }else {
                resultInfo.setFlag(false);
                resultInfo.setErrorMsg("账号或密码错误");
            }
        ObjectMapper mapper=new ObjectMapper();
//        "application/json;charset=utf-8"
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),resultInfo);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
