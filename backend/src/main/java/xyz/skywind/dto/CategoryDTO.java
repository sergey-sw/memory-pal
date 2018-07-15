package xyz.skywind.dto;

import xyz.skywind.category.Category;

/**
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at 15/07/2018.
 */
public class CategoryDTO {

    private long id;
    private String name;

    public CategoryDTO(Category category) {
        id = category.getId();
        name = category.getName();
    }

    public CategoryDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
