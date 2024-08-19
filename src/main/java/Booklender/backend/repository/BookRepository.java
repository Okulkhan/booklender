package Booklender.backend.repository;

import Booklender.backend.model.Book;
import Booklender.backend.model.userDetails.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("""
        SELECT b
        FROM Book b
        LEFT JOIN FETCH b.owners ow
        WHERE ow.id = :userId
""")
    List<Book> getBooksByUserId(long userId);
}
