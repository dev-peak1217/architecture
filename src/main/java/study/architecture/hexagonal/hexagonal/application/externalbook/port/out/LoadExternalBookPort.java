package study.architecture.hexagonal.hexagonal.application.externalbook.port.out;

import java.util.List;
import study.architecture.hexagonal.hexagonal.domain.model.ExternalBook;

public interface LoadExternalBookPort {

    List<ExternalBook> loadAllExternalBooks();

    ExternalBook loadExternalBookByIsbn(String isbn);
}
