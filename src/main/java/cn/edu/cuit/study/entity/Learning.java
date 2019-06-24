package cn.edu.cuit.study.entity;

/**
 * @author hl
 */
public class Learning {
    /**
     * 课程编号
     */
    private int courseId;

    /**
     * 用户编号
     */
    private int userId;

    /**
     * 课程名称
     */
    private String courseName;

    /**
     * 选课人数
     */
    private int selectNumber;

    /**
     * 教师名称
     */
    private String teacher;

    /**
     * 课程简介
     */
    private String content;

    /**
     * 图片路径
     */
    private String url;

    /**
     * 请求路径
     */
    private String link;

    /**
     * 学习进度
     */
    private String progress;


    public Learning() {
    }

    public Learning(int courseId, int userId, String courseName, int selectNumber, String teacher, String content, String url, String link, String progress) {
        this.courseId = courseId;
        this.userId = userId;
        this.courseName = courseName;
        this.selectNumber = selectNumber;
        this.teacher = teacher;
        this.content = content;
        this.url = url;
        this.link = link;
        this.progress = progress;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getSelectNumber() {
        return selectNumber;
    }

    public void setSelectNumber(int selectNumber) {
        this.selectNumber = selectNumber;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }


    @Override
    public String toString() {
        return "Learning{" +
                "courseId=" + courseId +
                ", userId=" + userId +
                ", courseName='" + courseName + '\'' +
                ", selectNumber=" + selectNumber +
                ", teacher='" + teacher + '\'' +
                ", content='" + content + '\'' +
                ", url='" + url + '\'' +
                ", link='" + link + '\'' +
                ", progress='" + progress + '\'' +
                '}';
    }
}
