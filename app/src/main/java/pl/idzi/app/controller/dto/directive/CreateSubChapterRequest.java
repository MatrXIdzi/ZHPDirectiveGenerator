package pl.idzi.app.controller.dto.directive;

import java.util.Map;

public class CreateSubChapterRequest {
    private String title;
    private Map<String, String> content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Map<String, String> getContent() {
        return content;
    }

    public void setContent(Map<String, String> content) {
        this.content = content;
    }
}
