package xyz.skywind.note;

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

    private Long userId = 1L;

    private long lastUpdateTs = System.currentTimeMillis();

    private String title;

    @Lob
    private String text;

    @OneToMany(mappedBy="note", cascade = CascadeType.ALL)
    private List<Tag> tags = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", userId=" + userId +
                ", lastUpdateTs=" + lastUpdateTs +
                ", title='" + title + '\'' +
                '}';
    }
}
