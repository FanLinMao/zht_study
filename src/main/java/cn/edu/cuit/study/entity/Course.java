package cn.edu.cuit.study.entity;

/**
 * @date: 2019/5/31
 * @author: Flemming
 * @description: 课程实体类
 */
public class Course {

    /**
     * 课程ID
     */
    private int courseID;
    /**
     * 课程名称
     */
    private String courseName;
    /**
     * 课程类别
     */
    private int categoryid;
    /**
     * 课程内容
     */
    private String content;
    /**
     * 授课教师
     */
    private String teacherName;
    /**
     * 选课人数
     */
    private int selectNum;
    /**
     * 上传时间
     */
    private String uploadtime;




    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(int categoryid) {
        this.categoryid = categoryid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public int getSelectNum() {
        return selectNum;
    }

    public void setSelectNum(int selectNum) {
        this.selectNum = selectNum;
    }

    public String getUploadtime() {
        return uploadtime;
    }

    public void setUploadtime(String uploadtime) {
        this.uploadtime = uploadtime;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseID=" + courseID +
                ", courseName='" + courseName + '\'' +
                ", categoryid=" + categoryid +
                ", content='" + content + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", selectNum=" + selectNum +
                ", uploadtime='" + uploadtime + '\'' +
                '}';
    }
}
