package study.architecture.hexagonal.mvc.model;

import java.time.LocalDateTime;
import study.architecture.hexagonal.mvc.dto.BookRequest;
import study.architecture.hexagonal.mvc.dto.BookResponse;
import study.architecture.hexagonal.mvc.entity.Book;

public class BookModel {

    private Long id;
    private String title;
    private String content;
    private String author;
    private Integer price;
    private String publisher;
    private LocalDateTime publishedDate;

    public BookModel(Long id, String title, String content, String author, Integer price, String publisher, LocalDateTime publishedDate) {
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

    public static BookModel fromEntity(Book entity) {
        return new BookModel(
            entity.getId(),
            entity.getTitle(),
            entity.getContent(),
            entity.getAuthor(),
            entity.getPrice(),
            entity.getPublisher(),
            entity.getPublishedDate()
        );
    }

    public static Book toEntity(BookModel model) {
        Book entity = new Book();
        entity.setId(model.getId());
        entity.setTitle(model.getTitle());
        entity.setContent(model.getContent());
        entity.setAuthor(model.getAuthor());
        entity.setPrice(model.getPrice());
        entity.setPublisher(model.getPublisher());
        entity.setPublishedDate(model.getPublishedDate());
        return entity;
    }

    public static BookModel fromRequest(BookRequest request) {
        return new BookModel(
            null,
            request.getTitle(),
            request.getContent(),
            request.getAuthor(),
            request.getPrice(),
            request.getPublisher(),
            request.getPublishedDate()
        );
    }

    public static BookResponse toResponse(BookModel model) {
        return new BookResponse(
            model.getId(),
            model.getTitle(),
            model.getContent(),
            model.getAuthor(),
            model.getPrice(),
            model.getPublisher(),
            model.getPublishedDate()
        );
    }
}
