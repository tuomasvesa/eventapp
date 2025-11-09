package hh_backend.eventapp.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventId;
    private String name;

    @JsonIgnoreProperties ("events")
    @ManyToOne
    @JoinColumn(name = "categoryId") // Foreign key
    private Category category;

    @JsonIgnoreProperties("events")
    @ManyToOne
    @JoinColumn(name = "cityId")
    private City city;

    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private Double price;
    private String description;
    private String review;
    private Boolean attended;

    // Constructors

    public Event() {}

    

    // Getters and setters

    public Event(String name, Category category, City city, LocalDate date, LocalTime startTime,
            LocalTime endTime, Double price, String description, String review, Boolean attended) {
        this.name = name;
        this.category = category;
        this.city = city;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.price = price;
        this.description = description;
        this.review = review;
        this.attended = attended;
    }



    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Boolean getAttended() {
        return attended;
    }

    public void setAttended(Boolean attended) {
        this.attended = attended;
    }


    @Override
    public String toString() {
        return "Event [id=" + eventId + ", name=" + name + ", category=" + category + ", city=" + city + ", date=" + date
                + ", startTime=" + startTime + ", endTime=" + endTime + ", price=" + price + ", description="
                + description + ", review=" + review + ", attended=" + attended + "]";
    }


 

    

    

}
