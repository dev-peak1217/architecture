package study.architecture.hexagonal.mvc.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import study.architecture.hexagonal.mvc.dto.ExternalBookResponse;
import study.architecture.hexagonal.mvc.model.ExternalBookModel;

@Service
public class ExternalBookServiceImpl implements ExternalBookService {

    @Override
    public List<ExternalBookResponse> fetchBooksFromExternalApi() {
        List<ExternalBookModel> models = fetchDummyExternalBooks();
        
        return models.stream()
            .map(this::toResponse)
            .toList();
    }

    @Override
    public ExternalBookResponse fetchBookByIsbn(String isbn) {
        ExternalBookModel model = new ExternalBookModel(
            "Sample Book for ISBN: " + isbn,
            "Unknown Author",
            isbn,
            4.5,
            100,
            "General",
            2024
        );
        
        return toResponse(model);
    }

    private List<ExternalBookModel> fetchDummyExternalBooks() {
        List<ExternalBookModel> books = new ArrayList<>();
        
        books.add(new ExternalBookModel(
            "Effective Java",
            "Joshua Bloch",
            "978-0134685991",
            4.8,
            523,
            "Programming",
            2018
        ));
        
        books.add(new ExternalBookModel(
            "Clean Code",
            "Robert C. Martin",
            "978-0132350884",
            4.7,
            892,
            "Software Engineering",
            2008
        ));
        
        books.add(new ExternalBookModel(
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

    private ExternalBookResponse toResponse(ExternalBookModel model) {
        return new ExternalBookResponse(
            model.getBookTitle(),
            model.getAuthorName(),
            model.getIsbn(),
            model.getRating(),
            model.getReviewCount(),
            model.getCategory(),
            model.getPublishYear()
        );
    }
}
