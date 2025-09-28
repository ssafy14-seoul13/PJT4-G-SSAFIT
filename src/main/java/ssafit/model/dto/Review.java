package ssafit.model.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Review {
    private int reviewId;
    private String videoId;
    private String userId;
    private String content;
    private String regDate;

    private static int autoIncrement = 1;

    public Review() {
    }

    public Review(String videoId, String userId, String content) {
        this.reviewId = autoIncrement++;
        this.videoId = videoId;
        this.userId = userId;
        this.content = content;
        this.regDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    @Override
    public String toString() {
        return "Review [reviewId=" + reviewId + ", videoId=" + videoId + ", userId=" + userId + ", content=" + content
                + ", regDate=" + regDate + "]";
    }
}
