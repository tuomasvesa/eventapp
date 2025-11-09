package hh_backend.eventapp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import hh_backend.eventapp.domain.EventRepository;
import hh_backend.eventapp.domain.Review;
import hh_backend.eventapp.domain.ReviewRepository;


@Controller
public class ReviewController {

    @Autowired
    private EventRepository eventRepo;
    private ReviewRepository reviewRepo;

    @GetMapping("/addreview/{id}")
    public String getReviewForm(@PathVariable("id") Long eventId, Model model) {
        model.addAttribute("event", eventRepo.findById(eventId));
        model.addAttribute("review", new Review());
        return "addreview"; // addreview.html
    }

    @PostMapping("/savenewreview")
    public String saveNewReview(@ModelAttribute Review newReview) {
        reviewRepo.save(newReview);
        return "redirect:/events"; // events.html

    }
}
