package study.architecture.hexagonal.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.architecture.hexagonal.mvc.entity.Book;

public interface MvcBookJpaRepository extends JpaRepository<Book, Long> {

}
