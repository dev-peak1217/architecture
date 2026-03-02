package study.architecture.hexagonal.hexagonal.adapter.out.externalapi;

import study.architecture.hexagonal.hexagonal.domain.model.ExternalBook;

public class ExternalBookApiDto {

    private String bookTitle;
    private String authorName;
    private String isbn;
    private Double rating;
    private Integer reviewCount;
    private String category;
    private Integer publishYear;

    public ExternalBookApiDto() {
    }

    public ExternalBookApiDto(String bookTitle, String authorName, String isbn, Double rating, Integer reviewCount, String category, Integer publishYear) {
        this.bookTitle = bookTitle;
        this.authorName = authorName;
        this.isbn = isbn;
        this.rating = rating;
        this.reviewCount = reviewCount;
        this.category = category;
        this.publishYear = publishYear;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Integer getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(Integer reviewCount) {
        this.reviewCount = reviewCount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(Integer publishYear) {
        this.publishYear = publishYear;
    }

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

    public static ExternalBookApiDto fromDomain(ExternalBook book) {
        return new ExternalBookApiDto(
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
