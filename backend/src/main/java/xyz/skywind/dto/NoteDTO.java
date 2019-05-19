package xyz.skywind.dto;

import xyz.skywind.category.Category;
import xyz.skywind.note.Note;
import xyz.skywind.tag.Tag;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at 22/04/2018.
 */
public class NoteDTO {

    private long id;

    private String title;

    private String text;

    private String category;

    private List<String> tags = Collections.emptyList();

    public NoteDTO() {
    }

    public NoteDTO(Note note) {
        this.id = note.getId();
        this.title = note.getTitle();
        this.text = note.getText();
        this.tags = note.getTags().stream().map(Tag::getName).collect(Collectors.toList());
        this.category = Optional.ofNullable(note.getCategory()).map(Category::getName).orElse("");
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "NoteDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", tags=" + tags +
                '}';
    }
}
