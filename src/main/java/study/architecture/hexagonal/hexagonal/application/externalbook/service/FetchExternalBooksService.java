package study.architecture.hexagonal.hexagonal.application.externalbook.service;

import java.util.List;
import org.springframework.stereotype.Service;
import study.architecture.hexagonal.hexagonal.application.externalbook.port.in.FetchExternalBooksUseCase;
import study.architecture.hexagonal.hexagonal.application.externalbook.port.out.LoadExternalBookPort;
import study.architecture.hexagonal.hexagonal.domain.model.ExternalBook;

@Service
public class FetchExternalBooksService implements FetchExternalBooksUseCase {

    private final LoadExternalBookPort loadExternalBookPort;

    public FetchExternalBooksService(LoadExternalBookPort loadExternalBookPort) {
        this.loadExternalBookPort = loadExternalBookPort;
    }

    @Override
    public List<ExternalBook> fetchAllExternalBooks() {
        return loadExternalBookPort.loadAllExternalBooks();
    }

    @Override
    public ExternalBook fetchExternalBookByIsbn(String isbn) {
        return loadExternalBookPort.loadExternalBookByIsbn(isbn);
    }
}
