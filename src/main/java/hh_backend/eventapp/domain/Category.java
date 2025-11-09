package hh_backend.eventapp.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;
    private String name;

    @JsonIgnoreProperties ({"category", "city"})
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category") // Linkittyy Event-entityluokan category-attribuuttiin
    private List<Event> events;

    // Constructors

    public Category() {}

    public Category(String name) {
        super();
        this.name = name;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryid) {
        this.categoryId = categoryid;
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
        return "Category [categoryid=" + categoryId + ", name=" + name + "]";
    }
    
    

    

    
}