package pl.idzi.app.model.directive;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.*;
import pl.idzi.app.model.user.User;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;
import java.util.UUID;

@Entity
public class Directive {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ElementCollection
    @CollectionTable(name = "directive_entries", joinColumns = @JoinColumn(name = "directive_id"))
    @MapKeyColumn(name = "chapter")
    @Column(name = "text")
    @Enumerated(EnumType.STRING)
    private TreeMap<ChapterTitle, SubChapter> chapters;

    @Temporal(TemporalType.DATE)
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

    private String serialNumber;

    private String city;

    public Directive() {
    }

    public Directive(TreeMap<ChapterTitle, SubChapter> chapters, LocalDate date, User author, String serialNumber, String city) {
        this.chapters = chapters;
        this.date = date;
        this.author = author;
        this.serialNumber = serialNumber;
        this.city = city;
    }

    public UUID getId() {
        return id;
    }

    public TreeMap<ChapterTitle, SubChapter> getChapters() {
        return chapters;
    }

    public void setChapters(TreeMap<ChapterTitle, SubChapter> chapters) {
        this.chapters = chapters;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
