package study.architecture.hexagonal.hexagonal.adapter.in.web.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.architecture.hexagonal.hexagonal.adapter.in.web.dto.BookRecord;
import study.architecture.hexagonal.hexagonal.application.book.port.in.CreateBookUseCase;
import study.architecture.hexagonal.hexagonal.application.book.port.in.GetBookUseCase;

@RestController
@RequestMapping("/hex/book")
public class BookController {

    private final GetBookUseCase getBookUseCase;
    private final CreateBookUseCase createBookUseCase;

    public BookController(GetBookUseCase getBookUseCase, CreateBookUseCase createBookUseCase) {
        this.getBookUseCase = getBookUseCase;
        this.createBookUseCase = createBookUseCase;
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @PostMapping("/save")
    public BookRecord save(@RequestBody BookRecord record) {
        return createBookUseCase.create(record);
    }

    @GetMapping("/{id}")
    public BookRecord findById(@PathVariable("id") Long id) {
        return getBookUseCase.findById(id);
    }

    @GetMapping("/all")
    public List<BookRecord> findAll() {
        return getBookUseCase.findAll();
    }

}
