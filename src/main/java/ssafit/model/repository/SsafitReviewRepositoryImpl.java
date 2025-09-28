package ssafit.model.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ssafit.model.dto.Review;

public class SsafitReviewRepositoryImpl implements SsafitReviewRepository {

    private static SsafitReviewRepository repo = new SsafitReviewRepositoryImpl();
    private Map<Integer, Review> reviewMap = new HashMap<>();

    private SsafitReviewRepositoryImpl() {
        // Dummy data
        reviewMap.put(1, new Review("gMaB-fG4u4g", "ssafy", "정말 유익한 영상입니다!"));
        reviewMap.put(2, new Review("gMaB-fG4u4g", "kim", "따라하기 쉽네요."));
    }

    public static SsafitReviewRepository getInstance() {
        return repo;
    }

    @Override
    public List<Review> selectByVideoId(String videoId) {
        List<Review> result = new ArrayList<>();
        for (Review review : reviewMap.values()) {
            if (review.getVideoId().equals(videoId)) {
                result.add(review);
            }
        }
        return result;
    }

    @Override
    public Review selectOne(int reviewId) {
        return reviewMap.get(reviewId);
    }

    @Override
    public void insertReview(Review review) {
        reviewMap.put(review.getReviewId(), review);
    }

    @Override
    public void updateReview(Review review) {
        reviewMap.put(review.getReviewId(), review);
    }

    @Override
    public void deleteReview(int reviewId) {
        reviewMap.remove(reviewId);
    }
}
