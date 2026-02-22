package study.architecture.hexagonal.mvc.service;

import java.util.List;
import study.architecture.hexagonal.mvc.dto.ExternalBookResponse;

public interface ExternalBookService {

    List<ExternalBookResponse> fetchBooksFromExternalApi();

    ExternalBookResponse fetchBookByIsbn(String isbn);

}
