package cn.edu.cuit.study.entity;

import java.util.Date;

/**
 * 历史记录实例
 * @author hl
 */
public class History {

    /**
     * 课程Id
     */
    private int courseId;

    /**
     * 用户Id
     */
    private int userId;

    /**
     * 课程名称
     */
    private String courseName;

    /**
     * 观看记录
     */
    private String learnDate;

    /**
     * 图片路径
     */
    private String url;

    /**
     * 学习进度
     */
    private int progress;

    public History() {
    }

    public History(int courseId, int userId, String courseName, String learnDate, String url, int progress) {
        this.courseId = courseId;
        this.userId = userId;
        this.courseName = courseName;
        this.learnDate = learnDate;
        this.url = url;
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

    public String getLearnDate() {
        return learnDate;
    }

    public void setLearnDate(String learnDate) {
        this.learnDate = learnDate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    @Override
    public String toString() {
        return "History{" +
                "courseId=" + courseId +
                ", userId=" + userId +
                ", courseName='" + courseName + '\'' +
                ", learnDate=" + learnDate +
                ", url='" + url + '\'' +
                ", progress=" + progress +
                '}';
    }
}
