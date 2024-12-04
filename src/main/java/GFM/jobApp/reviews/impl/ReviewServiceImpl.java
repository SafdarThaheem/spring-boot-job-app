package GFM.jobApp.reviews.impl;

import GFM.jobApp.company.Company;
import GFM.jobApp.company.CompanyService;
import GFM.jobApp.reviews.Review;
import GFM.jobApp.reviews.ReviewRepository;
import GFM.jobApp.reviews.ReviewService;
import org.springframework.stereotype.Service;

import java.rmi.NoSuchObjectException;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final CompanyService companyService;

    public ReviewServiceImpl(ReviewRepository reviewRepository, CompanyService companyService) {
        this.reviewRepository = reviewRepository;
        this.companyService = companyService;
    }

    @Override
    public Optional<List<Review>> getReviews(Long companyId) {
        return reviewRepository.findByCompanyId(companyId);
    }

    @Override
    public Company addReview(long companyId, Review review) throws NoSuchObjectException {
        Company company = companyService.getCompany(companyId);
        if (company == null) {
            throw new NoSuchObjectException("Company with id " + companyId + " not found!");
        }
        review.setCompany(company);
        reviewRepository.save(review);
        return company;
    }

    @Override
    public Review getReview(long companyId, long reviewId) {
        Optional<List<Review>> reviews = reviewRepository.findByCompanyId(companyId);
        return reviews.get().stream()
                .filter(review -> review.getId() == reviewId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Review updateReview(long companyId, long reviewId, Review updatedReview) {
        if (companyService.getCompany(companyId) != null) {
            updatedReview.setCompany(companyService.getCompany(companyId));
            updatedReview.setId(reviewId);
            reviewRepository.save(updatedReview);
            return updatedReview;
        }
        return null;
    }
}
