package hh_backend.eventapp;

import java.time.LocalDate;
import java.time.LocalTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh_backend.eventapp.domain.Category;
import hh_backend.eventapp.domain.CategoryRepository;
import hh_backend.eventapp.domain.City;
import hh_backend.eventapp.domain.CityRepository;
import hh_backend.eventapp.domain.Event;
import hh_backend.eventapp.domain.EventRepository;

@SpringBootApplication
public class EventappApplication {

	private static Logger Log = LoggerFactory.getLogger(EventappApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(EventappApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(EventRepository eventRepo, CategoryRepository categoryRepo, CityRepository cityRepo) {
		return (args) -> {
			Log.info("Save some categories");
			categoryRepo.save(new Category("concert"));
			categoryRepo.save(new Category("dance"));
			categoryRepo.save(new Category("play"));
			categoryRepo.save(new Category("expo"));

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

			eventRepo.save(new Event("Joulukonsertti", categoryRepo.findByName("concert"), 
							cityRepo.findByName("Helsinki"), LocalDate.of(2025, 12, 18), 
							LocalTime.of(19, 0), LocalTime.of(20, 30), 10.0, 
							"Joululauluja", "", false));
			eventRepo.save(new Event("Bachata night", categoryRepo.findByName("dance"), 
							cityRepo.findByName("Helsinki"), LocalDate.of(2025, 11, 20), 
							LocalTime.of(18, 0), LocalTime.of(21, 0), 5.0, 
							"Dance with a live band!", "", false));
			eventRepo.save(new Event("Speksi", categoryRepo.findByName("play"), 
							cityRepo.findByName("Espoo"), LocalDate.of(2025, 12,9), 
							LocalTime.of(18, 0), LocalTime.of(20, 00), 8.0, 
							"Hauskaa komediaa!", "", false));

			Log.info("fetch all events");
			for (Event event : eventRepo.findAll()) {
				Log.info(event.toString());
			}
		};
	}

}
