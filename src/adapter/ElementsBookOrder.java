package adapter;

import java.util.List;

public class ElementsBookOrder {
    private String author;
    private String title;
    private String genre;
    private String price;
    private String publish_date;
    private String description;
    private List<String> xmlElements;

    public ElementsBookOrder() {}

    public ElementsBookOrder(String author, String title, String genre, String price, String publish_date, String description, List<String> xmlElements) {
        this.author = author;
        this.title = title;
        this.genre = genre;
        this.price = price;
        this.publish_date = publish_date;
        this.description = description;
        this.xmlElements = xmlElements;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPublish_date() {
        return publish_date;
    }

    public void setPublish_date(String publish_date) {
        this.publish_date = publish_date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getXmlElements() {
        return xmlElements;
    }

    public void setXmlElements(List<String> xmlElements) {
        this.xmlElements = xmlElements;
    }


}
