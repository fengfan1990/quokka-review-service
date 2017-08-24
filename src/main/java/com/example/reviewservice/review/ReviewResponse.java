package com.example.reviewservice.review;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
final class ReviewResponse {
    private String id;
    private String title;
    private String year;
}
