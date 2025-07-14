import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;

public class TandFonlineScraper {
    public static void main(String[] args) throws IOException {
        // Connect to the website
        String url = "https://www.tandfonline.com/topic/allsubjects/ed";
        Document doc = Jsoup.connect(url).get();

        // Scrape the journal titles
        Elements journalTitles = doc.select("div.most-recent-articles > ul > li > div > div > h3 > a");
        System.out.println("Journal titles:");
        for (Element title : journalTitles) {
            System.out.println(title.text());
        }

        // Scrape the references
        Elements references = doc.select("div.most-recent-articles > ul > li > div > div > p > a");
        System.out.println("\nReferences:");
        for (Element reference : references) {
            System.out.println(reference.text());
        }
    }
}
