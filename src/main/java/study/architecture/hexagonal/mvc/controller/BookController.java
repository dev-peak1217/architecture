package study.architecture.hexagonal.mvc.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.architecture.hexagonal.mvc.entity.Book;
import study.architecture.hexagonal.mvc.service.BookService;

@RestController
@RequestMapping("/mvc/book")
public class BookController {

    BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @PostMapping("/save")
    public Book save(@RequestBody Book book) {
        return bookService.save(book);
    }

    @GetMapping("/{id}")
    public Book findById(@PathVariable("id") Long id) {
        return bookService.findById(id);
    }

    @GetMapping("/all")
    public List<Book> findAll() {
        return bookService.findAll();
    }

}
