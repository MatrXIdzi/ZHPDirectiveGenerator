package pl.idzi.app;

import org.springframework.cglib.core.Local;
import pl.idzi.app.model.directive.ChapterTitle;
import pl.idzi.app.model.directive.Directive;
import pl.idzi.app.model.directive.SubChapter;
import pl.idzi.app.model.directive.SubChapterTitle;
import pl.idzi.app.model.user.Unit;
import pl.idzi.app.model.user.User;
import pl.idzi.app.model.user.UserRole;
import pl.idzi.app.utils.DirectiveBinaryGenerator;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        SubChapter subChapter1 = new SubChapter();
        subChapter1.put(SubChapterTitle.SUBCHAPTER_1_1, "Subchapter one  Subchapter two Subchapter two\nSubchapter one Subchapter one Subchapter one Subchapter one Subchapter one Subchapter one \nSubchapter one \nSubchapter one Subchapter one Subchapter one");
        subChapter1.put(SubChapterTitle.SUBCHAPTER_1_2, "Subchapter two Subchapter two\nSubchapter two Subchapter two\nSubchapter two Subchapter two\nSubchapter two\nSubchapter two Subchapter two Subchapter two\nSubchapter Subchapter two Subchapter two Subchapter two two\nSubchapter Subchapter two Subchapter two Subchapter two two\nSubchapter Subchapter two Subchapter two Subchapter two Subchapter Subchapter two Subchapter two Subchapter two Subchapter Subchapter two Subchapter two Subchapter two Subchapter Subchapter two Subchapter two Subchapter two two\nSubchapter two\nSubchapter two Subchapter two Subchapter two Subchapter two Subchapter two Subchapter two Subchapter two\nSubchapter Subchapter two Subchapter two Subchapter two Subchapter Subchapter two Subchapter two Subchapter two Subchapter two Subchapter two Subchapter two Subchapter two");

        SubChapter subChapter2 = new SubChapter();
        subChapter2.put(SubChapterTitle.SUBCHAPTER_2_1, "Subchapter one1");
        subChapter2.put(SubChapterTitle.SUBCHAPTER_2_2, "Subchapter two1\nSubchapter two1");

        TreeMap<ChapterTitle, SubChapter> chapters = new TreeMap<>();
        chapters.put(ChapterTitle.CHAPTER_1, subChapter1);
        chapters.put(ChapterTitle.CHAPTER_2, subChapter2);

        Directive directive = new Directive();
        directive.setSerialNumber("123");
        directive.setCity("Warszawa");
        directive.setDate(LocalDate.of(2025,4,1));
        directive.setChapters(chapters);

        User user = new User("Karolina", "Ociepa", "karolinka.ociepa@gmail.com", "ciapson", "Haslo123", "pwd", "Namiestnik zuchowy", UserRole.USER, new Unit("Choragiew Lodzka", "Hufiec ZHP Reduta", null, null));

        directive.setAuthor(user);


        try {
            byte[] pfd = DirectiveBinaryGenerator.generateDirective(directive).getContent();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }
}
