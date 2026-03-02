package study.architecture.hexagonal.hexagonal.adapter.in.web.dto;

import study.architecture.hexagonal.hexagonal.domain.model.ExternalBook;

public record ExternalBookRecord(
    String bookTitle,
    String authorName,
    String isbn,
    Double rating,
    Integer reviewCount,
    String category,
    Integer publishYear
) {

    public ExternalBook toDomain() {
        return new ExternalBook(
            this.bookTitle,
            this.authorName,
            this.isbn,
            this.rating,
            this.reviewCount,
            this.category,
            this.publishYear
        );
    }

    public static ExternalBookRecord fromDomain(ExternalBook book) {
        return new ExternalBookRecord(
            book.getBookTitle(),
            book.getAuthorName(),
            book.getIsbn(),
            book.getRating(),
            book.getReviewCount(),
            book.getCategory(),
            book.getPublishYear()
        );
    }
}
