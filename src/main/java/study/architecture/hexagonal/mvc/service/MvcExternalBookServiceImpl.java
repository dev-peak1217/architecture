package study.architecture.hexagonal.mvc.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import study.architecture.hexagonal.mvc.dto.MvcExternalBookResponse;
import study.architecture.hexagonal.mvc.model.MvcExternalBookModel;

@Service
public class MvcExternalBookServiceImpl implements MvcExternalBookService {

    @Override
    public List<MvcExternalBookResponse> fetchBooksFromExternalApi() {
        List<MvcExternalBookModel> models = fetchDummyExternalBooks();
        
        return models.stream()
            .map(this::toResponse)
            .toList();
    }

    @Override
    public MvcExternalBookResponse fetchBookByIsbn(String isbn) {
        MvcExternalBookModel model = new MvcExternalBookModel(
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

    private List<MvcExternalBookModel> fetchDummyExternalBooks() {
        List<MvcExternalBookModel> books = new ArrayList<>();
        
        books.add(new MvcExternalBookModel(
            "Effective Java",
            "Joshua Bloch",
            "978-0134685991",
            4.8,
            523,
            "Programming",
            2018
        ));
        
        books.add(new MvcExternalBookModel(
            "Clean Code",
            "Robert C. Martin",
            "978-0132350884",
            4.7,
            892,
            "Software Engineering",
            2008
        ));
        
        books.add(new MvcExternalBookModel(
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

    private MvcExternalBookResponse toResponse(MvcExternalBookModel model) {
        return new MvcExternalBookResponse(
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
