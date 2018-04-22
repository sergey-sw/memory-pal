package xyz.skywind.dto;

import xyz.skywind.note.Note;
import xyz.skywind.tag.Tag;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at 22/04/2018.
 */
public class NoteDTO {

    private String title;

    private String text;

    private List<String> tags;

    public NoteDTO(Note note) {
        this.title = note.getTitle();
        this.text = note.getText();
        this.tags = note.getTags().stream().map(Tag::getName).collect(Collectors.toList());
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
}
