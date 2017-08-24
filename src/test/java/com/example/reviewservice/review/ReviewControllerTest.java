package com.example.reviewservice.review;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(ReviewController.class)
public class ReviewControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void createAReviewViaPostToReviews() throws Exception {
        final MockHttpServletRequestBuilder post = post("/reviews").contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "  \"title\": \"Gremlins\",\n" +
                        "  \"year\": 1984,\n" +
                        "  \"reviewer\": \"Hercules Mulligan\",\n" +
                        "  \"comment\": \"I loved it!\",\n" +
                        "  \"starRating\": 3.0\n" +
                        "}");

        mockMvc.perform(post)
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", is("5")))
                .andExpect(jsonPath("$.title", is("Gremlins")))
                .andExpect(jsonPath("$.year", is("1984")));

    }

    @Test
    public void getAReviewViaGetToReviews() throws Exception {
        final MockHttpServletRequestBuilder get = get("/reviews");

        mockMvc.perform(get)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is("5")))
                .andExpect(jsonPath("$.title", is("Gremlins")))
                .andExpect(jsonPath("$.year", is("1984")));
    }
}