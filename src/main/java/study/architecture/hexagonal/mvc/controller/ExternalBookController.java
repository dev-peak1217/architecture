package study.architecture.hexagonal.mvc.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.architecture.hexagonal.mvc.dto.ExternalBookResponse;
import study.architecture.hexagonal.mvc.service.ExternalBookService;

@RestController
@RequestMapping("/mvc/external/book")
public class ExternalBookController {

    private final ExternalBookService externalBookService;

    public ExternalBookController(ExternalBookService externalBookService) {
        this.externalBookService = externalBookService;
    }

    @GetMapping("/all")
    public List<ExternalBookResponse> fetchAllBooks() {
        return externalBookService.fetchBooksFromExternalApi();
    }

    @GetMapping("/isbn/{isbn}")
    public ExternalBookResponse fetchBookByIsbn(@PathVariable String isbn) {
        return externalBookService.fetchBookByIsbn(isbn);
    }
}
