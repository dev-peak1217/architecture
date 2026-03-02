package study.architecture.hexagonal.hexagonal.application.externalbook.port.in;

import java.util.List;
import study.architecture.hexagonal.hexagonal.domain.model.ExternalBook;

public interface FetchExternalBooksUseCase {

    List<ExternalBook> fetchAllExternalBooks();

    ExternalBook fetchExternalBookByIsbn(String isbn);
}
