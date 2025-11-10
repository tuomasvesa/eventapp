package hh_backend.eventapp;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import hh_backend.eventapp.web.EventController;
import hh_backend.eventapp.web.ReviewController;


@SpringBootTest
class EventappApplicationTests {

	@Autowired
	private EventController eventController;

	@Autowired
	private ReviewController reviewController;

	@Test
	void contextLoads() {
		assertThat(eventController).isNotNull();
		assertThat(reviewController).isNotNull();
	}

}
