package com.example.reviewservice.review;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reviews")
public final class ReviewController {

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED )
    public ReviewResponse createReview() {
        return ReviewResponse.builder().id("5").title("Gremlins").year("1984").build();
    }

    @GetMapping("")
    public ReviewResponse getReview(){
        return ReviewResponse.builder().id("5").title("Gremlins").year("1984").build();
    }
}
