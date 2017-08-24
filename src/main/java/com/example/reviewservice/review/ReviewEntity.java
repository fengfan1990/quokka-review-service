package com.example.reviewservice.review;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
final class ReviewEntity {
    @Id
    private Long id;

    private Long movieId;
    private String reviewer;
    private String comment;
    private double starRating;
}
