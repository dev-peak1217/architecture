package study.architecture.hexagonal.mvc.service;

import java.util.List;
import study.architecture.hexagonal.mvc.model.BookModel;

public interface BookService {

    BookModel save(BookModel bookModel);

    BookModel findById(Long id);

    List<BookModel> findAll();

}
