package service;

import domain.User;
import Dao.loginDao;
public class loginService {
    
    public User login(User user){
        loginDao dao=new loginDao();
        User loginUser = dao.login(user);
        return loginUser;
    }
}
