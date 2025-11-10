package hh_backend.eventapp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import hh_backend.eventapp.domain.Event;
import hh_backend.eventapp.domain.EventRepository;
import hh_backend.eventapp.domain.Review;
import hh_backend.eventapp.domain.ReviewRepository;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class ReviewController {

    @Autowired
    private EventRepository eventRepo;
    @Autowired
    private ReviewRepository reviewRepo;

    @GetMapping("/addreview/{id}")
    public String getReviewForm(@PathVariable("id") Long eventId, Model model) {
        Event event = eventRepo.findById(eventId).orElseThrow(() -> new RuntimeException("Event not found: " + eventId));
        model.addAttribute("event", event);
        model.addAttribute("review", new Review());
        return "addreview"; // addreview.html
    }

    @PostMapping("/savenewreview")
    public String saveNewReview(@ModelAttribute Review newReview, BindingResult bingingResult, @RequestParam Long eventId) {
        if (bingingResult.hasErrors()) {
            return "addreview/{id}";
        }
        Event event = eventRepo.findById(eventId).orElseThrow(() -> new RuntimeException("Event not found: " + eventId));
        newReview.setEvent(event);
        event.setReview(newReview);
        reviewRepo.save(newReview);
        return "redirect:/eventlist"; // eventlist.html
    }

    @GetMapping("/viewreview/{id}")
    public String getMethodName(@PathVariable("id") Long eventId, Model model) {
        Event event = eventRepo.findById(eventId).orElseThrow(() -> new RuntimeException("Event not found: " + eventId));
        model.addAttribute("event", event);
        model.addAttribute("review", event.getReview());
        return "viewreview"; // viewreview.html
    }
    
}
