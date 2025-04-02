package pl.idzi.app.model.directive;

import jakarta.persistence.*;

import java.util.List;
import java.util.TreeMap;

@Embeddable
public class SubChapter {

    private String title;

    @ElementCollection
    @CollectionTable(name = "subchapter_contents", joinColumns = @JoinColumn(name = "subchapter_id"))
    @MapKeyEnumerated(EnumType.STRING)
    @MapKeyColumn(name = "subchapter_title")
    @Column(name = "content")
    private TreeMap<SubChapterTitle,String> content = new TreeMap<>();

    public SubChapter() {
    }

    public SubChapter(String title) {
        this.title = title;
    }

    public SubChapter(String title, TreeMap<SubChapterTitle, String> content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TreeMap<SubChapterTitle, String> getContent() {
        return content;
    }

    public void setContent(TreeMap<SubChapterTitle, String> content) {
        this.content = content;
    }

    public void put(SubChapterTitle subChapterTitle, String content) {
        this.content.put(subChapterTitle, content);
    }
}
