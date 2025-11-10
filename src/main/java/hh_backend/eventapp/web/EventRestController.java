package hh_backend.eventapp.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import hh_backend.eventapp.domain.Event;
import hh_backend.eventapp.domain.EventRepository;


@RestController
public class EventRestController {

    @Autowired
    private EventRepository eventRepo;

    @GetMapping("/events")
    public @ResponseBody List<Event> getEventListRest() {
        return (List<Event>) eventRepo.findAll();
    }

    @GetMapping("/events/{id}")
    public @ResponseBody Optional<Event> findEventById(@PathVariable("id") Long eventId) {
        return eventRepo.findById(eventId);
    }

}
