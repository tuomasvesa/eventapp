package hh_backend.eventapp.web;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import hh_backend.eventapp.domain.Event;
//import hh_backend.eventapp.EventappApplication;
import hh_backend.eventapp.domain.CategoryRepository;
import hh_backend.eventapp.domain.CityRepository;
import hh_backend.eventapp.domain.EventRepository;
import hh_backend.eventapp.domain.Review;
import hh_backend.eventapp.domain.ReviewRepository;

@Controller
public class EventController {


    @Autowired
    private EventRepository eventRepo;

    @Autowired
    private CategoryRepository categoryRepo;

    @Autowired
    private CityRepository cityRepo;

    @Autowired
    private ReviewRepository reviewRepo;

    /* 
    EventController(EventappApplication eventappApplication, CommandLineRunner demo) {
        this.eventappApplication = eventappApplication;
        this.demo = demo;
    }
     */

 
    @GetMapping("/index")
    public String getFrontPage() {
        return "index"; // index.html
    }

    @GetMapping("/eventlist")
    public String getEvents(Model model) {
        model.addAttribute("events", eventRepo.findAll());
        return "eventlist"; // eventlist.html
    }

    @GetMapping("/addevent")
    public String addNewEvent(Model model) {
        model.addAttribute("event", new Event());
        model.addAttribute("categories", categoryRepo.findAll());
        model.addAttribute("cities", cityRepo.findAll());
        return "addevent"; // addevent.html

    }

    @PostMapping("/savenewevent")
    public String saveNewEvent(@ModelAttribute Event newEvent) {
        eventRepo.save(newEvent);
        return "redirect:/eventlist"; // eventlist.html
    }

    @GetMapping("/deleteevent/{id}")
    public String deleteEvent(@PathVariable("id") Long eventId) {
        eventRepo.deleteById(eventId);
        return "redirect:/eventlist";
    }

    @GetMapping("editevent/{id}")
    public String getEditEventForm(@PathVariable("id") Long eventId, Model model) {
        Event event = eventRepo.findById(eventId).orElseThrow(() -> new RuntimeException("Event not found " + eventId));
        model.addAttribute("event", event);
        model.addAttribute("categories", categoryRepo.findAll());
        model.addAttribute("cities", cityRepo.findAll());
        return "editevent"; // editevent.html
    }

    @PostMapping("/updateevent")
    public String updateEvent(@ModelAttribute Event event) {
        Review review = reviewRepo.findByEvent(event);
        event.setReview(review);
        eventRepo.save(event);
        return "redirect:/eventlist"; // eventlist.html
        
    }
}
