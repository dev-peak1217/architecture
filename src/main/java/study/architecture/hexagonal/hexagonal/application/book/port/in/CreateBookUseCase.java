package study.architecture.hexagonal.hexagonal.application.book.port.in;

import study.architecture.hexagonal.hexagonal.adapter.in.web.dto.BookRecord;

public interface CreateBookUseCase {

    BookRecord create(BookRecord record);

}
