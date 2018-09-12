
import javax.persistence.*;

@Entity
@javax.persistence.Table(name = "news")
public class News {

    public News(String date, String newsText) {
        this.date = date;
        this.newsText = newsText;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "dateOfNews")
    private String date;

    @Column(name = "newsText")
    private String newsText;

    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getNewsText() {
        return newsText;
    }


}
