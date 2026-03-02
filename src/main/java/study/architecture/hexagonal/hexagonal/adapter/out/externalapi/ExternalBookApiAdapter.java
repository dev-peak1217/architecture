package study.architecture.hexagonal.hexagonal.adapter.out.externalapi;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import study.architecture.hexagonal.hexagonal.application.externalbook.port.out.LoadExternalBookPort;
import study.architecture.hexagonal.hexagonal.domain.model.ExternalBook;

@Component
public class ExternalBookApiAdapter implements LoadExternalBookPort {

    @Override
    public List<ExternalBook> loadAllExternalBooks() {
        List<ExternalBookApiDto> apiDtos = fetchDummyExternalBooksFromApi();
        return apiDtos.stream()
            .map(ExternalBookApiDto::toDomain)
            .toList();
    }

    @Override
    public ExternalBook loadExternalBookByIsbn(String isbn) {
        ExternalBookApiDto apiDto = fetchExternalBookFromApiByIsbn(isbn);
        return apiDto.toDomain();
    }

    private List<ExternalBookApiDto> fetchDummyExternalBooksFromApi() {
        List<ExternalBookApiDto> books = new ArrayList<>();
        
        books.add(new ExternalBookApiDto(
            "Effective Java",
            "Joshua Bloch",
            "978-0134685991",
            4.8,
            523,
            "Programming",
            2018
        ));
        
        books.add(new ExternalBookApiDto(
            "Clean Code",
            "Robert C. Martin",
            "978-0132350884",
            4.7,
            892,
            "Software Engineering",
            2008
        ));
        
        books.add(new ExternalBookApiDto(
            "Domain-Driven Design",
            "Eric Evans",
            "978-0321125217",
            4.6,
            341,
            "Architecture",
            2003
        ));
        
        return books;
    }

    private ExternalBookApiDto fetchExternalBookFromApiByIsbn(String isbn) {
        return new ExternalBookApiDto(
            "Sample Book for ISBN: " + isbn,
            "Unknown Author",
            isbn,
            4.5,
            100,
            "General",
            2024
        );
    }
}
