package study.architecture.hexagonal.hexagonal.adapter.out.persistence.book;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import study.architecture.hexagonal.hexagonal.application.book.port.out.LoadBookPort;
import study.architecture.hexagonal.hexagonal.application.book.port.out.SaveBookPort;
import study.architecture.hexagonal.hexagonal.domain.model.Book;

@Repository
public class BookPersistenceAdapter implements LoadBookPort, SaveBookPort {

    private final Logger log;
    private final BookJpaRepository bookJpaRepository;

    public BookPersistenceAdapter(BookJpaRepository bookJpaRepository) {
        this.log = LoggerFactory.getLogger(this.getClass());
        this.bookJpaRepository = bookJpaRepository;
    }

    @Override
    public Book save(Book book) {

        log.info("[BookDatabaseRepository] save book: {}", book.getTitle());
        return bookJpaRepository.save(BookEntity.fromDomain(book)).toDomain();
    }

    @Override
    public List<Book> findAll() {

        log.info("[BookDatabaseRepository] Find all books");
        return bookJpaRepository.findAll().stream()
            .map(BookEntity::toDomain).toList();
    }

    @Override
    public Book findById(Long id) {

        log.info("[BookDatabaseRepository] Find book by id {}", id);
        return bookJpaRepository.findById(id).map(BookEntity::toDomain).orElse(null);
    }
}
