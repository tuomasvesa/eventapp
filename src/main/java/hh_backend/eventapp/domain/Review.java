package hh_backend.eventapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long reviewId;
    @NotNull(message = "Score cannot be null")
    private int score;
    @NotNull(message = "Review text cannot be null")
    private String reviewText;
    @JsonIgnoreProperties ({"category", "city", "review"})
    @OneToOne
    @JoinColumn(name = "eventId")
    private Event event;

    public Review() {
    };

    public Review(int score, String reviewText, Event event) {
        this.score = score;
        this.reviewText = reviewText;
        this.event = event;
    }

    public Long getReviewId() {
        return reviewId;
    }

    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "Review [reviewId=" + reviewId + ", score=" + score + ", reviewText=" + reviewText + ", event name="
                + event.getName() + "]";
    }

    

}
