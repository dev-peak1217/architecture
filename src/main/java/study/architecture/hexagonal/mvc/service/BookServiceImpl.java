package study.architecture.hexagonal.mvc.service;

import java.util.List;
import org.springframework.stereotype.Service;
import study.architecture.hexagonal.mvc.entity.Book;
import study.architecture.hexagonal.mvc.repository.BookJpaRepository;

@Service
public class BookServiceImpl implements BookService {

    BookJpaRepository bookJpaRepository;

    public BookServiceImpl(BookJpaRepository bookJpaRepository) {
        this.bookJpaRepository = bookJpaRepository;
    }

    @Override
    public Book save(Book book) {
        return bookJpaRepository.save(book);
    }

    @Override
    public Book findById(Long id) {
        return bookJpaRepository.findById(id).orElse(null);
    }

    @Override
    public List<Book> findAll() {
        return bookJpaRepository.findAll();
    }
}
