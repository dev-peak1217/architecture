package study.architecture.hexagonal.hexagonal.application.book.port.in;

import java.util.List;
import study.architecture.hexagonal.hexagonal.adapter.in.web.dto.BookRecord;

public interface GetBookUseCase {

    List<BookRecord> findAll();

    BookRecord findById(Long id);

}
