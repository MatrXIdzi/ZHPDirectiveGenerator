package pl.idzi.app.model.directive;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.*;
import pl.idzi.app.model.AbstractEntity;
import pl.idzi.app.model.user.User;

import java.time.LocalDate;
import java.util.*;

@Entity
public class Directive extends AbstractEntity {

    @CollectionTable(name = "directive_entries", joinColumns = @JoinColumn(name = "directive_id"))
    @MapKeyColumn(name = "chapter")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private LinkedHashMap<ChapterTitle, SubChapter> chapters = new LinkedHashMap<>();

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
        this.chapters = new LinkedHashMap<>(chapters);
        this.date = date;
        this.author = author;
        this.serialNumber = serialNumber;
        this.city = city;
    }

    public TreeMap<ChapterTitle, SubChapter> getChapters() {
        return new TreeMap<>(chapters);
    }

    public void setChapters(TreeMap<ChapterTitle, SubChapter> chapters) {
        this.chapters = new LinkedHashMap<>(chapters);
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
