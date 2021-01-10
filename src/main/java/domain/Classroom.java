package domain;
//教室状态表
public class Classroom {
    private String status;
    private String week;
    private String weekDay;
    private String session;
    private String classroomID;
    private String teacherID;
    private String snum;
    private String type;

    public String getClassroomID() {
        return classroomID;
    }

    public void setClassroomID(String classroomID) {
        this.classroomID = classroomID;
    }

    public String getSnum() {
        return snum;
    }

    public void setSnum(String snum) {
        this.snum = snum;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(String teacherID) {
        this.teacherID = teacherID;
    }

    @Override
    public String toString() {
        return "Classroom{" +
                "status='" + status + '\'' +
                ", week='" + week + '\'' +
                ", weekDay='" + weekDay + '\'' +
                ", session='" + session + '\'' +
                ", classroomID='" + classroomID + '\'' +
                ", teacherID='" + teacherID + '\'' +
                ", snum='" + snum + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
