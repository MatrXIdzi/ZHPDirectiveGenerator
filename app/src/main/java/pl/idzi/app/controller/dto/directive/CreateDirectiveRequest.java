package pl.idzi.app.controller.dto.directive;

import java.time.LocalDate;
import java.util.Map;

public class CreateDirectiveRequest {
    private Map<String, CreateSubChapterRequest> chapters;
    private LocalDate date;
    private String authorUsername; // lub authorUsername/email jak wolisz
    private String serialNumber;
    private String city;

    public Map<String, CreateSubChapterRequest> getChapters() {
        return chapters;
    }

    public void setChapters(Map<String, CreateSubChapterRequest> chapters) {
        this.chapters = chapters;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getAuthorUsername() {
        return authorUsername;
    }

    public void setAuthorUsername(String authorId) {
        this.authorUsername = authorId;
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

