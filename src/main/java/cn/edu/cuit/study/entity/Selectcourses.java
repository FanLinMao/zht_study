package cn.edu.cuit.study.entity;

public class Selectcourses extends SelectcoursesKey {
    private Integer select;

    private String downpath;

    private String downtime;

    private String note;

    private String notetime;

    public Integer getSelect() {
        return select;
    }

    public void setSelect(Integer select) {
        this.select = select;
    }

    public String getDownpath() {
        return downpath;
    }

    public void setDownpath(String downpath) {
        this.downpath = downpath == null ? null : downpath.trim();
    }

    public String getDowntime() {
        return downtime;
    }

    public void setDowntime(String downtime) {
        this.downtime = downtime == null ? null : downtime.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public String getNotetime() {
        return notetime;
    }

    public void setNotetime(String notetime) {
        this.notetime = notetime == null ? null : notetime.trim();
    }
}