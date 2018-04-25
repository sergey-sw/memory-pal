package xyz.skywind.tag;

import xyz.skywind.note.Note;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at 22/04/2018.
 */
@Entity
@Table(name = "tags")
public class Tag {

    @Id
    @GeneratedValue
    private Long id;

    private long userId;

    private String name;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "tags"
    )
    private Set<Note> notes = new HashSet<>();

    public Tag() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Note> getNotes() {
        return notes;
    }

    public void setNotes(Set<Note> notes) {
        this.notes = notes;
    }
}
