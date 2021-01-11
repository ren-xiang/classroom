package domain;

public class Course {
    private String cid;
    private String minRequest;
    private String teacherID;
    private String type;
    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getMinRequest() {
        return minRequest;
    }

    public void setMinRequest(String minRequest) {
        this.minRequest = minRequest;
    }

    public String getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(String teacherID) {
        this.teacherID = teacherID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Course{" +
                "cid='" + cid + '\'' +
                ", minRequest='" + minRequest + '\'' +
                ", teacherID='" + teacherID + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
