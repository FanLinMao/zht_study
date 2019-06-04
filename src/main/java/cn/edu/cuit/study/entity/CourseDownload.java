package cn.edu.cuit.study.entity;

/**
 * 课程下载实例
 * @author hl
 */
public class CourseDownload {
    /**
     * 课程编号
     */
    private int courseId;

    /**
     * 课程名称
     */
    private String courseName;

    /**
     * 课程下载地址
     */
    private String downloadUrl;

    public CourseDownload(int courseId, String courseName, String downloadUrl) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.downloadUrl = downloadUrl;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }
}
