package ssafit.model.service;

import java.util.List;

import ssafit.model.dto.Review;
import ssafit.model.repository.SsafitReviewRepository;
import ssafit.model.repository.SsafitReviewRepositoryImpl;

public class SsafitReviewServiceImpl implements SsafitReviewService {

    private static SsafitReviewService service = new SsafitReviewServiceImpl();
    private SsafitReviewRepository repo = SsafitReviewRepositoryImpl.getInstance();

    private SsafitReviewServiceImpl() {}

    public static SsafitReviewService getInstance() {
        return service;
    }

    @Override
    public List<Review> getReviewList(String videoId) {
        return repo.selectByVideoId(videoId);
    }

    @Override
    public Review getReview(int reviewId) {
        return repo.selectOne(reviewId);
    }

    @Override
    public void createReview(Review review) {
        repo.insertReview(review);
    }

    @Override
    public void modifyReview(Review review) {
        repo.updateReview(review);
    }

    @Override
    public void removeReview(int reviewId) {
        repo.deleteReview(reviewId);
    }
}
