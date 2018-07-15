package xyz.skywind.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.skywind.dto.CategoryDTO;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at 15/07/2018.
 */
@RestController
public class CategoryController {

    @Autowired
    private CategoryRepository repository;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/api/categories")
    public List<CategoryDTO> getCategories() {
        return repository.findAll().stream().map(CategoryDTO::new).collect(Collectors.toList());
    }
}
