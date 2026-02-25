package study.architecture.hexagonal.hexagonal.adapter.in.web.dto;

import java.time.LocalDateTime;
import study.architecture.hexagonal.hexagonal.domain.model.Book;

public record BookRecord(Long id, String title, String content, String author, Integer price, String publisher, LocalDateTime publishedDate) {

    public Book toDomain() {
        return new Book(
            this.id,
            this.title,
            this.content,
            this.author,
            this.price,
            this.publisher,
            this.publishedDate
        );
    }

    public static BookRecord fromDomain(Book book) {
        return new BookRecord(
            book.getId(),
            book.getTitle(),
            book.getContent(),
            book.getAuthor(),
            book.getPrice(),
            book.getPublisher(),
            book.getPublishedDate()
        );
    }
}
