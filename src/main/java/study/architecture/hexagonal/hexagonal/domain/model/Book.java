package study.architecture.hexagonal.hexagonal.domain.model;

import java.time.LocalDateTime;

public class Book {

    private Long id;
    private String title;
    private String content;
    private String author;
    private Integer price;
    private String publisher;
    private LocalDateTime publishedDate;

    public Book() {}

    public Book(Long id, String title, String content, String author, Integer price, String publisher, LocalDateTime publishedDate) {
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

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }

    public Integer getPrice() {
        return price;
    }

    public String getPublisher() {
        return publisher;
    }

    public LocalDateTime getPublishedDate() {
        return publishedDate;
    }

}
