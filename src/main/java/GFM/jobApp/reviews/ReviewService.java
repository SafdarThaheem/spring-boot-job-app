package GFM.jobApp.reviews;

import GFM.jobApp.company.Company;

import java.rmi.NoSuchObjectException;
import java.util.List;
import java.util.Optional;

public interface ReviewService {
    Optional<List<Review>> getReviews(Long companyId);
    Company addReview(long companyId, Review review) throws NoSuchObjectException;
}
