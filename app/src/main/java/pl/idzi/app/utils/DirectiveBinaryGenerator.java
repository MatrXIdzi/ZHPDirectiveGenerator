package pl.idzi.app.utils;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.*;
import pl.idzi.app.model.directive.*;

import javax.sound.midi.Soundbank;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DirectiveBinaryGenerator {

    private static final PDFont FONT = new PDType1Font(Standard14Fonts.FontName.HELVETICA);
    private static final float FONT_SIZE = 10;
    private static final float LEADING = -1.5f * FONT_SIZE;
    private static float heightLeft;
    private static float actualWidth;
    private static float marginY;
    private static float marginX;
    private static float width;
    private static float startX;
    private static float startY;

    public static DirectiveBinary generateDirective(Directive directive) throws IOException {
        DirectiveBinary directiveBinary = new DirectiveBinary();
        directiveBinary.setDirective(directive);
        directiveBinary.setContent(generateDirectiveContent(directive.getChapters(), directive));
        return directiveBinary;
    }

    private static byte[] generateDirectiveContent(TreeMap<ChapterTitle, SubChapter> chapters, Directive directive) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage();
            document.addPage(page);
            PDPageContentStream contentStream = new PDPageContentStream(document, page);

            PDRectangle mediaBox = page.getMediaBox();
            marginY = 80;
            marginX = 60;
            width = mediaBox.getWidth() - 2 * marginX;
            startX = mediaBox.getLowerLeftX() + marginX;
            startY = mediaBox.getUpperRightY() - marginY;

            heightLeft = mediaBox.getHeight() - 2 * marginY;
            actualWidth = startX;

            contentStream.beginText();
            contentStream.setFont(FONT, FONT_SIZE);
            contentStream.newLineAtOffset(startX, startY);
            int chapterCounter = 1;
            String zhp = "Zwiazek Harcersta Polskiego";
            String cityDate = directive.getCity() + ", " + directive.getDate().getDayOfMonth() + "." + (directive.getDate().getMonthValue() < 10 ? "0" + directive.getDate().getMonthValue() : directive.getDate().getMonthValue()) + "." + directive.getDate().getYear() + "r";

            String tempLineHeader = zhp + " " + cityDate;
            float sizeLH = FONT_SIZE * FONT.getStringWidth(tempLineHeader) / 1000;
            float spaceSize = FONT_SIZE * FONT.getStringWidth(" ") / 1000;
            int spaceCount = (int)(sizeLH/spaceSize);

            String spaces = " ".repeat(spaceCount);
            String firstLineHeader = tempLineHeader.substring(0,zhp.length()) + spaces + tempLineHeader.substring(zhp.length());
            addParagraph(contentStream, width, 0, 0, firstLineHeader);
            addParagraph(contentStream, width, 0, 0, directive.getAuthor().getUnit().getRegion());
            addParagraph(contentStream, width, 0, 0, directive.getAuthor().getUnit().getDistrict());
            if(directive.getAuthor().getUnit().getGroup() != null) {
                addParagraph(contentStream, width, 0, 0, directive.getAuthor().getUnit().getGroup());
                }
            if(directive.getAuthor().getUnit().getTroop() != null) {
                addParagraph(contentStream, width, 0, 0, directive.getAuthor().getUnit().getTroop());
                }

            String title = "ROZKAZ L." + directive.getSerialNumber() + "/" + directive.getDate().getYear();

            float sizeT = FONT_SIZE * FONT.getStringWidth(title) / 1000;

            contentStream.newLineAtOffset((width-sizeT)/2, 0);

            addParagraph(contentStream, width, 0, 0, title);

            contentStream.newLineAtOffset(-(width-sizeT)/2, 0);

            for (Map.Entry<ChapterTitle, SubChapter> entry : chapters.entrySet()) {
                contentStream = addPageIfNeeded(contentStream, document, true);
                addParagraph(contentStream, width, 0, 0, chapterCounter + ". " + entry.getKey().label);
                contentStream = addPageIfNeeded(contentStream, document, false);

                int subChapterCounter = 1;
                contentStream.newLineAtOffset(30, 0);
                actualWidth += 30;
                for (Map.Entry<SubChapterTitle, String> subEntry : entry.getValue().getContent().entrySet()) {
                    contentStream = addPageIfNeeded(contentStream, document, true);
                    addParagraph(contentStream, width-30, 0, 0, chapterCounter + "." + subChapterCounter + ". " + subEntry.getKey().label);
                    contentStream = addPageIfNeeded(contentStream, document, false);

                    int lineCounter = 1;
                    List<String> lines = List.of(subEntry.getValue().split("\n"));
                    contentStream.newLineAtOffset(30, 0);
                    actualWidth += 30;
                    for (String line : lines) {
                        contentStream = addPageIfNeeded(contentStream, document, true);
                        addParagraph(contentStream, width-60, 0, 0, chapterCounter + "." + subChapterCounter + "." + lineCounter + ". " + line);
                        contentStream = addPageIfNeeded(contentStream, document, false);
                        lineCounter++;
                    }
                    contentStream.newLineAtOffset(-30, 0);
                    actualWidth -= 30;
                    subChapterCounter++;
                }
                chapterCounter++;
                contentStream.newLineAtOffset(-30, 0);
                actualWidth -= 30;
            }
            contentStream.newLineAtOffset(0, -30);
            actualWidth -= 30;
            String [] signature = {
                    "Z harcerskim pozdrowieniem",
                    "Czuwaj!",
                    directive.getAuthor().getFunction(),
                    directive.getAuthor().getRank() + ". " + directive.getAuthor().getFirstname() + " " + directive.getAuthor().getSurname()
            };
            for(int i = 0; i < 4; i++) {
                float size = FONT_SIZE * FONT.getStringWidth(signature[i]) / 1000;
                contentStream = addPageIfNeeded(contentStream, document, true);
                contentStream.newLineAtOffset(width - size, 0);
                addParagraph(contentStream, width, 0, 0, signature[i]);
                contentStream.newLineAtOffset(- (width - size), 0);
                contentStream = addPageIfNeeded(contentStream, document, false);
            }

            contentStream.endText();
            contentStream.close();

            document.save("directive.pdf");
            document.save(outputStream);
        }
        return outputStream.toByteArray();
    }

    private static void addParagraph(PDPageContentStream contentStream, float width, float sx,
                                     float sy, String text) throws IOException {
        List<String> lines = parseLines(text, width);
        contentStream.newLineAtOffset(sx, sy);
        boolean flag = true;
        for (String line: lines) {
            contentStream.showText(line);
            contentStream.newLineAtOffset(0, LEADING);
            heightLeft += LEADING;
            if(lines.size() > 1 && flag) {
                contentStream.newLineAtOffset(27, 0);
                flag = false;
            }
        }
        if(lines.size() > 1) {
            contentStream.newLineAtOffset(-27, 0);
        }
    }

    private static PDPageContentStream addPageIfNeeded(PDPageContentStream contentStream, PDDocument document, boolean preTest) throws IOException {
        float tempHeight = heightLeft;
        if (!preTest) {
            tempHeight += LEADING;
        }
        if (tempHeight <= 0) {
            PDPage page = new PDPage();
            document.addPage(page);
            contentStream.endText();
            contentStream.close();
            contentStream = new PDPageContentStream(document, page);
            contentStream.beginText();
            contentStream.setFont(FONT, FONT_SIZE);
            contentStream.newLineAtOffset(actualWidth, startY);

            heightLeft = page.getMediaBox().getHeight() - 2 * marginY;
        }
        return contentStream;
    }

    private static List<String> parseLines(String text, float width) throws IOException {
        List<String> lines = new ArrayList<>();
        int lastSpace = -1;
        while (!text.isEmpty()) {
            int spaceIndex = text.indexOf(' ', lastSpace + 1);
            if (spaceIndex < 0)
                spaceIndex = text.length();
            String subString = text.substring(0, spaceIndex);
            float size = FONT_SIZE * FONT.getStringWidth(subString) / 1000;
            if (size > width) {
                if (lastSpace < 0){
                    lastSpace = spaceIndex;
                }
                subString = text.substring(0, lastSpace);
                lines.add(subString);
                text = text.substring(lastSpace).trim();
                lastSpace = -1;
            } else if (spaceIndex == text.length()) {
                lines.add(text);
                text = "";
            } else {
                lastSpace = spaceIndex;
            }
        }
        return lines;
    }
}
