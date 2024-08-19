package Booklender.backend.exception;

public class BookNotFoundException extends RuntimeException{
        public BookNotFoundException(Long bookId) {
            super("Книга с таким ID " + bookId + " не найден");
    }
}
