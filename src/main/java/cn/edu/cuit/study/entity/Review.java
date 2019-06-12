package cn.edu.cuit.study.entity;

public class Review extends ReviewKey {
    private String review;

    private String reviewtime;

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review == null ? null : review.trim();
    }

    public String getReviewtime() {
        return reviewtime;
    }

    public void setReviewtime(String reviewtime) {
        this.reviewtime = reviewtime == null ? null : reviewtime.trim();
    }
}