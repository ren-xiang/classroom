package domain;

public class NewClassroom {
    private String classroomID;
    private String cid;
    private String teacherID;
    private String status;
    private String week;
    private String weekDay;
    private String session;
    private String cname;
    private String snum;
    private String type;

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

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
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

    @Override
    public String toString() {
        return "NewClassroom{" +
                "classroomID='" + classroomID + '\'' +
                ", cid='" + cid + '\'' +
                ", teacherID='" + teacherID + '\'' +
                ", status='" + status + '\'' +
                ", week='" + week + '\'' +
                ", weekDay='" + weekDay + '\'' +
                ", session='" + session + '\'' +
                ", cname='" + cname + '\'' +
                ", snum='" + snum + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
