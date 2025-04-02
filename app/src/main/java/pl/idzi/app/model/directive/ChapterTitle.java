package pl.idzi.app.model.directive;

public enum ChapterTitle {
    CHAPTER_1("Informacje i zarzadzenia"), CHAPTER_2("Mianowania i zwolnienia"), CHAPTER_3("Stopnie i Sprawnosci");
    public final String label;

    ChapterTitle(String label) {
        this.label = label;
    }
}
