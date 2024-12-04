package GFM.jobApp.reviews;

import java.util.List;
import java.util.Optional;

public interface ReviewService {
    Optional<List<Review>> getReviews(Long companyId);
}
