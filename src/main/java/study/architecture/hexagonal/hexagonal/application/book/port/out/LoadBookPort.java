package study.architecture.hexagonal.hexagonal.application.book.port.out;

import java.util.List;
import study.architecture.hexagonal.hexagonal.domain.model.Book;

public interface LoadBookPort {

    List<Book> findAll();

    Book findById(Long id);

}
