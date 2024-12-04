package GFM.jobApp.reviews;

import GFM.jobApp.util.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/reviews")
    public ResponseEntity<ApiResponse> getReviews(@PathVariable Long companyId) {
        Optional<List<Review>> reviews = reviewService.getReviews(companyId);
        if (reviews.get().isEmpty()) {
            ApiResponse failedResponse = new ApiResponse(
                    HttpStatus.NOT_FOUND.name(),
                    "No Content Available!",
                    reviews.get()
            );
            return new ResponseEntity<>(failedResponse, HttpStatus.NOT_FOUND);
        }
        ApiResponse successResponse = new ApiResponse(
                HttpStatus.OK.name(),
                "Content Available!",
                reviews.get()
        );
        return new ResponseEntity<>(successResponse, HttpStatus.OK);
    }
}
