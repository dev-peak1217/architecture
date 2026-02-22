package study.architecture.hexagonal.mvc.service;

import java.util.List;
import study.architecture.hexagonal.mvc.entity.Book;

public interface BookService {

    Book save(Book book);

    Book findById(Long id);

    List<Book> findAll();

}
