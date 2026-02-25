package study.architecture.hexagonal.hexagonal.application.book.port.out;

import study.architecture.hexagonal.hexagonal.domain.model.Book;

public interface SaveBookPort {

    Book save(Book book);

}
