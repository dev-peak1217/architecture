package study.architecture.hexagonal.mvc.service;

import java.util.List;
import study.architecture.hexagonal.mvc.dto.MvcExternalBookResponse;

public interface MvcExternalBookService {

    List<MvcExternalBookResponse> fetchBooksFromExternalApi();

    MvcExternalBookResponse fetchBookByIsbn(String isbn);

}
