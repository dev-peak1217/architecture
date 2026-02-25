package study.architecture.hexagonal.hexagonal.application.book.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import study.architecture.hexagonal.hexagonal.adapter.in.web.dto.BookRecord;
import study.architecture.hexagonal.hexagonal.application.book.port.in.CreateBookUseCase;
import study.architecture.hexagonal.hexagonal.application.book.port.out.SaveBookPort;

/*
* 책을 생성하는 역할을 담당
* */
@Service
public class CreateBookService implements CreateBookUseCase {

    private final Logger log;
    private final SaveBookPort saveBookPort;

    public CreateBookService(SaveBookPort saveBookPort) {
        this.log = LoggerFactory.getLogger(this.getClass());
        this.saveBookPort = saveBookPort;
    }

    @Override
    public BookRecord create(BookRecord record) {

        log.info("[CreateBookService] Find book title: {}", record.title());
        return BookRecord.fromDomain(saveBookPort.save(record.toDomain()));
    }
}
