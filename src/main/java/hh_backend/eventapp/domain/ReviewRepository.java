package hh_backend.eventapp.domain;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface ReviewRepository extends CrudRepository<Review, Long> {
    List<Review> findByScore(int score);
    Review findByEvent(Event event);
}




