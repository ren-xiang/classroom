package domain;
//用户登陆
public class User {
    private String teacherID;
    private String password;

    public String getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(String teacherID) {
        this.teacherID = teacherID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "teacherID='" + teacherID + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
