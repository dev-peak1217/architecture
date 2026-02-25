package study.architecture.hexagonal.mvc.service;

import java.util.List;
import org.springframework.stereotype.Service;
import study.architecture.hexagonal.mvc.entity.Book;
import study.architecture.hexagonal.mvc.model.BookModel;
import study.architecture.hexagonal.mvc.repository.MvcBookJpaRepository;

@Service
public class BookServiceImpl implements BookService {

    private final MvcBookJpaRepository mvcBookJpaRepository;

    public BookServiceImpl(MvcBookJpaRepository mvcBookJpaRepository) {
        this.mvcBookJpaRepository = mvcBookJpaRepository;
    }

    @Override
    public BookModel save(BookModel bookModel) {
        Book entity = toEntity(bookModel);
        Book savedEntity = mvcBookJpaRepository.save(entity);
        return toModel(savedEntity);
    }

    @Override
    public BookModel findById(Long id) {
        return mvcBookJpaRepository.findById(id)
            .map(this::toModel)
            .orElse(null);
    }

    @Override
    public List<BookModel> findAll() {
        return mvcBookJpaRepository.findAll().stream()
            .map(this::toModel)
            .toList();
    }

    private Book toEntity(BookModel model) {
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

    private BookModel toModel(Book entity) {
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
}
