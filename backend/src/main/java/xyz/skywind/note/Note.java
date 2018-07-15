package xyz.skywind.note;

import xyz.skywind.category.Category;
import xyz.skywind.tag.Tag;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: Sergey Saiyan sergey.sova42@gmail.com
 * Created at 24/03/2018.
 */

@Entity
@Table(name = "notes")
public class Note {

    @Id
    @GeneratedValue
    private Long id;

    private long lastUpdateTs = System.currentTimeMillis();

    private String title;

    @Lob
    private String text;

    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    @JoinTable(
            name = "note_tags",
            joinColumns = {@JoinColumn(name = "note_id")},
            inverseJoinColumns = {@JoinColumn(name = "tag_id")}
    )
    private List<Tag> tags = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getLastUpdateTs() {
        return lastUpdateTs;
    }

    public void setLastUpdateTs(long lastUpdateTs) {
        this.lastUpdateTs = lastUpdateTs;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", lastUpdateTs=" + lastUpdateTs +
                ", title='" + title + '\'' +
                ", category=" + category +
                '}';
    }
}
