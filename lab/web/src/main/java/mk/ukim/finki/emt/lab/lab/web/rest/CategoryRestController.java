package mk.ukim.finki.emt.lab.lab.web.rest;
import mk.ukim.finki.emt.lab.lab.model.Category;
import mk.ukim.finki.emt.lab.lab.service.CategoryService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/categories")
public class CategoryRestController {
    private final CategoryService categoryService;


    public CategoryRestController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> findAll() {
        return this.categoryService.listCategories();
    }
}
