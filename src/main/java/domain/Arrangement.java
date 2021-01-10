package domain;

public class Arrangement {
    private String classroomID;
    private String cid;
    private String teacherID;
    private String status;
    private String week;
    private String weekDay;
    private String session;

    public Arrangement() {

    }

    public Arrangement(String classroomID, String cid, String teacherID, String status, String week, String weekDay, String session) {
        this.classroomID = classroomID;
        this.cid = cid;
        this.teacherID = teacherID;
        this.status = status;
        this.week = week;
        this.weekDay = weekDay;
        this.session = session;
    }

    public String getClassroomID() {
        return classroomID;
    }

    public void setClassroomID(String classroomID) {
        this.classroomID = classroomID;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(String teacherID) {
        this.teacherID = teacherID;
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

    @Override
    public String toString() {
        return "Arrangement{" +
                "classroomID='" + classroomID + '\'' +
                ", cid='" + cid + '\'' +
                ", teacherID='" + teacherID + '\'' +
                ", status='" + status + '\'' +
                ", week='" + week + '\'' +
                ", weekDay='" + weekDay + '\'' +
                ", session='" + session + '\'' +
                '}';
    }
}

