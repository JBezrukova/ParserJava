import org.jsoup.nodes.Document;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.io.IOException;

public class Parser implements Job{

/*

    public static void main(String[] args) {
        Parser parser = new Parser();
        try {
            parser.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
*/
    public void run()throws IOException {
        //without downloading
        Document document = Jsoup.connect("https://www.fontanka.ru").get();

        System.out.println(document.title());
        Elements elements = document.select("a.sb-item__title");
        String date;
        String text;
        DBConnection connection = new DBConnection();
        NewsDAO newsDAO = new NewsDAO();
        for (Element elements1 : elements) {
            date = elements1.attr("href");
            text = elements1.ownText();
            System.out.println("Time/Date: " + date);
            System.out.println("Заголовок: " + text);
            News news = new News(date, text);
            newsDAO.addNew(news, connection.getConnection());

        }
    }

    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        Parser parser = new Parser();
        try {
            parser.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

