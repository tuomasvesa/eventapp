package hh_backend.eventapp.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

// Finnish cities
@Entity
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cityId;
    private String name;

    @JsonIgnoreProperties({ "category", "city" })
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "city")
    private List<Event> events;

    public City() {
    }

    public City(String name) {
        super();
        this.name = name;
    }


    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long id) {
        this.cityId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    
    @Override
    public String toString() {
        return "City [id=" + cityId + ", name=" + name + "]";
    }
}
