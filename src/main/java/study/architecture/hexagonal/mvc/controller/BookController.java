package study.architecture.hexagonal.mvc.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.architecture.hexagonal.mvc.dto.BookRequest;
import study.architecture.hexagonal.mvc.dto.BookResponse;
import study.architecture.hexagonal.mvc.model.BookModel;
import study.architecture.hexagonal.mvc.service.BookService;

@RestController
@RequestMapping("/mvc/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @PostMapping("/save")
    public BookResponse save(@RequestBody BookRequest request) {
        BookModel model = new BookModel(
            null,
            request.getTitle(),
            request.getContent(),
            request.getAuthor(),
            request.getPrice(),
            request.getPublisher(),
            request.getPublishedDate()
        );
        
        BookModel savedModel = bookService.save(model);
        
        return new BookResponse(
            savedModel.getId(),
            savedModel.getTitle(),
            savedModel.getContent(),
            savedModel.getAuthor(),
            savedModel.getPrice(),
            savedModel.getPublisher(),
            savedModel.getPublishedDate()
        );
    }

    @GetMapping("/{id}")
    public BookResponse findById(@PathVariable("id") Long id) {
        BookModel model = bookService.findById(id);
        if (model == null) {
            return null;
        }
        
        return new BookResponse(
            model.getId(),
            model.getTitle(),
            model.getContent(),
            model.getAuthor(),
            model.getPrice(),
            model.getPublisher(),
            model.getPublishedDate()
        );
    }

    @GetMapping("/all")
    public List<BookResponse> findAll() {
        return bookService.findAll().stream()
            .map(model -> new BookResponse(
                model.getId(),
                model.getTitle(),
                model.getContent(),
                model.getAuthor(),
                model.getPrice(),
                model.getPublisher(),
                model.getPublishedDate()
            ))
            .toList();
    }

}
