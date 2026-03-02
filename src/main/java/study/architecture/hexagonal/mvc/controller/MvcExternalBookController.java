package study.architecture.hexagonal.mvc.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.architecture.hexagonal.mvc.dto.MvcExternalBookResponse;
import study.architecture.hexagonal.mvc.service.MvcExternalBookService;

@RestController
@RequestMapping("/mvc/external/book")
public class MvcExternalBookController {

    private final MvcExternalBookService mvcExternalBookService;

    public MvcExternalBookController(MvcExternalBookService mvcExternalBookService) {
        this.mvcExternalBookService = mvcExternalBookService;
    }

    @GetMapping("/all")
    public List<MvcExternalBookResponse> fetchAllBooks() {
        return mvcExternalBookService.fetchBooksFromExternalApi();
    }

    @GetMapping("/isbn/{isbn}")
    public MvcExternalBookResponse fetchBookByIsbn(@PathVariable String isbn) {
        return mvcExternalBookService.fetchBookByIsbn(isbn);
    }
}
