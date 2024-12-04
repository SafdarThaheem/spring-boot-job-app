package GFM.jobApp.reviews.impl;

import GFM.jobApp.reviews.Review;
import GFM.jobApp.reviews.ReviewRepository;
import GFM.jobApp.reviews.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Optional<List<Review>> getReviews(Long companyId) {
        return reviewRepository.findByCompanyId(companyId);
    }
}
