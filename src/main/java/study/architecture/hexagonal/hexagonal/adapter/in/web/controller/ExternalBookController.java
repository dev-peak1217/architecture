package study.architecture.hexagonal.hexagonal.adapter.in.web.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.architecture.hexagonal.hexagonal.adapter.in.web.dto.ExternalBookRecord;
import study.architecture.hexagonal.hexagonal.application.externalbook.port.in.FetchExternalBooksUseCase;

@RestController
@RequestMapping("/hexagonal/external/book")
public class ExternalBookController {

    private final FetchExternalBooksUseCase fetchExternalBooksUseCase;

    public ExternalBookController(FetchExternalBooksUseCase fetchExternalBooksUseCase) {
        this.fetchExternalBooksUseCase = fetchExternalBooksUseCase;
    }

    @GetMapping("/all")
    public List<ExternalBookRecord> fetchAllBooks() {
        return fetchExternalBooksUseCase.fetchAllExternalBooks()
            .stream()
            .map(ExternalBookRecord::fromDomain)
            .toList();
    }

    @GetMapping("/isbn/{isbn}")
    public ExternalBookRecord fetchBookByIsbn(@PathVariable String isbn) {
        return ExternalBookRecord.fromDomain(
            fetchExternalBooksUseCase.fetchExternalBookByIsbn(isbn)
        );
    }
}
