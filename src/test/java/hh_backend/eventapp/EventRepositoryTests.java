package hh_backend.eventapp;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import hh_backend.eventapp.domain.CategoryRepository;
import hh_backend.eventapp.domain.CityRepository;
import hh_backend.eventapp.domain.Event;
import hh_backend.eventapp.domain.EventRepository;

@DataJpaTest
public class EventRepositoryTests {

    @Autowired
    private EventRepository eventRepo;

    @Autowired
    private CategoryRepository categoryRepo;

    @Autowired
    private CityRepository cityRepo;

    @Test
    public void testFindSomething() {

    }
    

    @Test
    public void createNewEvent() {

        Event event = new Event("Hamlet", categoryRepo.findByName("Play").get(0),
                cityRepo.findByName("Helsinki").get(0), LocalDate.of(2025, 12, 16),
                LocalTime.of(19, 0), LocalTime.of(20, 30), 10.0,
                "Shakespearen klassikkonäytelmä", null, false);
        eventRepo.save(event);

        assertThat(event.getEventId()).isNotNull();
    }

    @Test
    public void findByName() {
        List<Event> events = eventRepo.findByName("Joulukonsertti");
        assertThat(events).hasSize(1);
        assertThat(events.get(0).getCategory().getName()).isEqualTo("Concert");
    }

    @Test
    public void deleteEventById() {
        List<Event> events = eventRepo.findByName("Joulukonsertti");
        Long id = events.get(0).getEventId();
        eventRepo.deleteById(id);
        assertThat(eventRepo.findByName("Joulukonsertti")).hasSize(0);
    }

    @Test
    void findById() {
        List<Event> events = eventRepo.findByName("Joulukonsertti");
        Long id = events.get(0).getEventId();
        Optional<Event> foundEvent = eventRepo.findById(id);
        assertThat(foundEvent).isPresent();
        assertThat(foundEvent.get().getName()).isEqualTo("Joulukonsertti");
    }

    @Test
    void findAll() {
        Iterable<Event> events = eventRepo.findAll();
        assertThat(events).hasSize(3);
    }

}
