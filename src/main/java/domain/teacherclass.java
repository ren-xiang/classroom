package domain;
//教师课表
public class teacherclass {
    private String teacherID;
    private String cid;
    private String cname;
    private String classroomID;
    private String week;
    private String weekDay;
    private String session;

    public String getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(String teacherID) {
        this.teacherID = teacherID;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getClassroomID() {
        return classroomID;
    }

    public void setClassroomID(String classroomID) {
        this.classroomID = classroomID;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(String weekDay) {
        this.weekDay = weekDay;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    @Override
    public String toString() {
        return "teacherclass{" +
                "teacherID='" + teacherID + '\'' +
                ", cid='" + cid + '\'' +
                ", cname='" + cname + '\'' +
                ", classroomID='" + classroomID + '\'' +
                ", week='" + week + '\'' +
                ", weekDay='" + weekDay + '\'' +
                ", session='" + session + '\'' +
                '}';
    }
}
