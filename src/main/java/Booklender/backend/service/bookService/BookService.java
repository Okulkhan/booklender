package Booklender.backend.service.bookService;

import Booklender.backend.dto.booksDto.BookDto;
import Booklender.backend.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    List<BookDto> getAll();

    BookDto takeBook(long bookId, long userId);

    BookDto returnBook(long userId, long bookId);
}
