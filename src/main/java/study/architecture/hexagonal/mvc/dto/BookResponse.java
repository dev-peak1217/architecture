package study.architecture.hexagonal.mvc.dto;

import java.time.LocalDateTime;

public class BookResponse {

    private Long id;
    private String title;
    private String content;
    private String author;
    private Integer price;
    private String publisher;
    private LocalDateTime publishedDate;

    public BookResponse() {
    }

    public BookResponse(Long id, String title, String content, String author, Integer price, String publisher, LocalDateTime publishedDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.price = price;
        this.publisher = publisher;
        this.publishedDate = publishedDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public LocalDateTime getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDateTime publishedDate) {
        this.publishedDate = publishedDate;
    }
}
