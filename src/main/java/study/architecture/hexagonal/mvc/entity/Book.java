package study.architecture.hexagonal.mvc.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private String author;
    private Integer price;
    private String publisher;
    private LocalDateTime publishedDate;

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
