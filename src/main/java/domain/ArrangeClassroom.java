package domain;

import sun.dc.pr.PRError;

public class ArrangeClassroom {
    private String classroomID;
    private String snum;
    private String type;
    private String week;
    private String weekDay;
    private String session;

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
        return "ArrangeClassroom{" +
                "classroomID='" + classroomID + '\'' +
                ", snum='" + snum + '\'' +
                ", type='" + type + '\'' +
                ", week='" + week + '\'' +
                ", weekDay='" + weekDay + '\'' +
                ", session='" + session + '\'' +
                '}';
    }
}
