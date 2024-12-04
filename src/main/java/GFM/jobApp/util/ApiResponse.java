package GFM.jobApp.util;


public record ApiResponse(
        String status,
        String message,
        Object data
) {
}
