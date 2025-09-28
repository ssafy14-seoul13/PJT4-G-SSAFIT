package ssafit.model.repository;

import java.util.List;
import ssafit.model.dto.Review;

public interface SsafitReviewRepository {
    List<Review> selectByVideoId(String videoId);
    Review selectOne(int reviewId);
    void insertReview(Review review);
    void updateReview(Review review);
    void deleteReview(int reviewId);
}
