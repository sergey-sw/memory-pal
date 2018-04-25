package xyz.skywind.dto;

import xyz.skywind.tag.Tag;

/**
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at 25/04/2018.
 */
public class TagDTO {

    private String name;

    public TagDTO() {
    }

    public TagDTO(Tag tag) {
        this.name = tag.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
