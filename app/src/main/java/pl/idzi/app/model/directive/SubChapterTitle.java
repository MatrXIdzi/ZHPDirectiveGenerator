package pl.idzi.app.model.directive;

public enum SubChapterTitle {
    SUBCHAPTER_1_1("Informacje"), SUBCHAPTER_1_2("Zarzadzenia"), SUBCHAPTER_2_1("Mianowania"), SUBCHAPTER_2_2("Zwolnienia"), SUBCHAPTER_3_1("Stopnie"), SUBCHAPTER_3_2("Sprawnosci");

    public final String label;

    SubChapterTitle(String label) {
        this.label = label;
    }
}
