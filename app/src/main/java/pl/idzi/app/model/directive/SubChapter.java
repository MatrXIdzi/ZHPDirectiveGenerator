package pl.idzi.app.model.directive;

import jakarta.persistence.*;
import pl.idzi.app.model.AbstractEntity;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Entity
public class SubChapter extends AbstractEntity {

    private String title;

    @ElementCollection
    @CollectionTable(name = "subchapter_contents", joinColumns = @JoinColumn(name = "subchapter_id"))
    @MapKeyEnumerated(EnumType.STRING)
    @MapKeyColumn(name = "subchapter_title")
    @Column(name = "content")
    private LinkedHashMap<SubChapterTitle, String> content = new LinkedHashMap<>();

    public SubChapter() {
    }

    public SubChapter(String title) {
        this.title = title;
    }

    public SubChapter(String title, TreeMap<SubChapterTitle, String> content) {
        this.title = title;
        this.content = new LinkedHashMap<>(content);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TreeMap<SubChapterTitle, String> getContent() {
        return new TreeMap<>(content);
    }

    public void setContent(Map<SubChapterTitle, String> content) {
        this.content = new LinkedHashMap<>(content);
    }

    public void put(SubChapterTitle subChapterTitle, String content) {
        this.content.put(subChapterTitle, content);
    }
}
