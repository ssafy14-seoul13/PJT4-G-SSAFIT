package ssafit.model.service;

import java.util.List;
import ssafit.model.dto.Review;

public interface SsafitReviewService {
    List<Review> getReviewList(String videoId);
    Review getReview(int reviewId);
    void createReview(Review review);
    void modifyReview(Review review);
    void removeReview(int reviewId);
}
