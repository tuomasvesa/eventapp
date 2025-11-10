package hh_backend.eventapp;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;
import hh_backend.eventapp.domain.Category;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import hh_backend.eventapp.domain.CategoryRepository;

@DataJpaTest
public class CategoryRepositoryTests {

    @Autowired
    private CategoryRepository categoryRepo;

    @Test
    public void createNewCategory() {
        Category category = new Category("Concert");
        categoryRepo.save(category);
        assertThat(category.getCategoryId()).isNotNull();
    }

    @Test
    public void deleteCategoryById() {
        List<Category> category = categoryRepo.findByName("Concert");
        Long id = category.get(0).getCategoryId();
        categoryRepo.deleteById(id);
        assertThat(categoryRepo.findByName("Concert")).hasSize(1);
    }

    @Test
    void findAll() {
        Iterable<Category> categories = categoryRepo.findAll();
        assertThat(categories).hasSize(3);
    }

    @Test
    void findById() {
        List<Category> categories = categoryRepo.findByName("Concert");
        Long id = categories.get(0).getCategoryId();
        Optional<Category> foundCategory = categoryRepo.findById(id);
        assertThat(foundCategory).isPresent();
        assertThat(foundCategory.get().getName()).isEqualTo("Concert");
    }

}
