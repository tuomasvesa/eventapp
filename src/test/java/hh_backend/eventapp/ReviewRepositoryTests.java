package hh_backend.eventapp;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


//import hh_backend.eventapp.domain.EventRepository;
import hh_backend.eventapp.domain.Review;
import hh_backend.eventapp.domain.ReviewRepository;

@DataJpaTest
public class ReviewRepositoryTests {

    @Autowired
    private ReviewRepository reviewRepo;

    //@Autowired
    //private EventRepository eventRepo;

    @Test
    public void createNewReview() {
        Review review = new Review(4, "Hyvä!", null);
        reviewRepo.save(review);
        assertThat(review.getReviewId()).isNotNull();
    }

}
