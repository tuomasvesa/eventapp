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

@Controller
public class EventController {


    @Autowired
    private EventRepository eventRepo;

    @Autowired
    private CategoryRepository categoryRepo;

    @Autowired
    private CityRepository cityRepo;

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

    @GetMapping("/events")
    public String getEvents(Model model) {
        model.addAttribute("events", eventRepo.findAll());
        return "events"; // events.html
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
        return "redirect:/events"; // events.html
    }

    @GetMapping("/deleteevent/{id}")
    public String deleteEvent(@PathVariable("id") Long eventId) {
        eventRepo.deleteById(eventId);
        return "redirect:/events";
    }

    @GetMapping("editevent/{id}")
    public String getEditEventForm(@PathVariable("id") Long eventId, Model model) {
        model.addAttribute("event", eventRepo.findById(eventId));
        model.addAttribute("categories", categoryRepo.findAll());
        model.addAttribute("cities", cityRepo.findAll());
        return "editevent"; // editevent.html
    }

    @PostMapping("/updateevent")
    public String updateEvent(@ModelAttribute Event event) {
        eventRepo.save(event);
        return "redirect:/events"; // events.html
        
    }
}
