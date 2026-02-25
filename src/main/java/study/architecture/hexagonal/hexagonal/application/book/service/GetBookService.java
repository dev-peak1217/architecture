package study.architecture.hexagonal.hexagonal.application.book.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import study.architecture.hexagonal.hexagonal.adapter.in.web.dto.BookRecord;
import study.architecture.hexagonal.hexagonal.application.book.port.in.GetBookUseCase;
import study.architecture.hexagonal.hexagonal.application.book.port.out.LoadBookPort;

@Service
public class GetBookService implements GetBookUseCase {

    private final Logger log;
    private final LoadBookPort loadBookPort;

    public GetBookService(LoadBookPort loadBookPort) {
        this.log = LoggerFactory.getLogger(this.getClass());
        this.loadBookPort = loadBookPort;
    }

    @Override
    public List<BookRecord> findAll() {

        log.info("[GetBookService] Find all books");
        return loadBookPort.findAll().stream()
            .map(BookRecord::fromDomain).toList();
    }

    @Override
    public BookRecord findById(Long id) {

        log.info("[GetBookService] Find book by id: {}", id);
        return BookRecord.fromDomain(loadBookPort.findById(id));
    }
}
