package hh_backend.eventapp;

import java.time.LocalDate;
import java.time.LocalTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh_backend.eventapp.domain.AppUser;
import hh_backend.eventapp.domain.Category;
import hh_backend.eventapp.domain.CategoryRepository;
import hh_backend.eventapp.domain.City;
import hh_backend.eventapp.domain.CityRepository;
import hh_backend.eventapp.domain.Event;
import hh_backend.eventapp.domain.EventRepository;
import hh_backend.eventapp.domain.ReviewRepository;
import hh_backend.eventapp.domain.UserRepository;

@SpringBootApplication
public class EventappApplication {

	private static Logger Log = LoggerFactory.getLogger(EventappApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(EventappApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(EventRepository eventRepo, CategoryRepository categoryRepo, CityRepository cityRepo,
			ReviewRepository reviewRepo, UserRepository userRepo) {
		return (args) -> {
			Log.info("Save some categories");
			categoryRepo.save(new Category("Concert"));
			categoryRepo.save(new Category("Dance"));
			categoryRepo.save(new Category("Play"));
			categoryRepo.save(new Category("Expo"));

			Log.info("fetch all categories");
			for (Category category : categoryRepo.findAll()) {
				Log.info(category.toString());
			}

			Log.info("Save some cities");
			cityRepo.save(new City("Helsinki"));
			cityRepo.save(new City("Espoo"));
			cityRepo.save(new City("Vantaa"));
			cityRepo.save(new City("Tampere"));
			cityRepo.save(new City("Joensuu"));

			Log.info("fetch all cities");
			for (City city : cityRepo.findAll()) {
				Log.info(city.toString());
			}

			Log.info("Save some events");

			eventRepo.save(new Event("Joulukonsertti", categoryRepo.findByName("Concert").get(0),
					cityRepo.findByName("Helsinki").get(0), LocalDate.of(2025, 12, 18),
					LocalTime.of(19, 0), LocalTime.of(20, 30), 10.0,
					"Joululauluja", null, false));
			eventRepo.save(new Event("Bachata night", categoryRepo.findByName("Dance").get(0),
					cityRepo.findByName("Helsinki").get(0), LocalDate.of(2025, 11, 20),
					LocalTime.of(18, 0), LocalTime.of(21, 0), 5.0,
					"Dance with a live band!", null, false));
			eventRepo.save(new Event("Speksi", categoryRepo.findByName("Play").get(0),
					cityRepo.findByName("Espoo").get(0), LocalDate.of(2025, 12, 9),
					LocalTime.of(18, 0), LocalTime.of(20, 00), 8.0,
					"Hauskaa komediaa!", null, false));

			AppUser user1 = new AppUser("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6",
					"user@gmail.com", "USER");
			AppUser user2 = new AppUser("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C",
					"admin@gmail.com", "ADMIN");
			AppUser user3 = new AppUser("tuomas", "$2a$12$6huzdDEbBjP3ZcR3.gA.8u/FmmPEPAV62jS2hxWL4ASauPTtw9Op2",
					"tuomas@gmail.com", "ADMIN");
			userRepo.save(user1);
			userRepo.save(user2);
			userRepo.save(user3);

			Log.info("fetch all events");
			for (Event event : eventRepo.findAll()) {
				Log.info(event.toString());
			}
		};
	}

}
