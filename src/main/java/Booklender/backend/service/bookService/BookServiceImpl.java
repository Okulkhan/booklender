package Booklender.backend.service.bookService;

import Booklender.backend.dto.booksDto.BookDto;
import Booklender.backend.dto.booksDto.BookMapper;
import Booklender.backend.exception.BookNotFoundException;
import Booklender.backend.exception.UserNotFoundException;
import Booklender.backend.model.Book;
import Booklender.backend.model.userDetails.User;
import Booklender.backend.repository.BookRepository;
import Booklender.backend.repository.identityRepository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService{

    private BookRepository bookRepository;

    private BookMapper bookMapper;

    private UserRepository userRepository;

    @Override
    public List<BookDto> getAll (){
            List<Book> bookList = bookRepository.findAll();
            List<BookDto> bookDto = new ArrayList<>();

            for (Book book : bookList) {
                bookDto.add(bookMapper.convertToDto(book));
            }
            return bookDto;
        }

    @Override
    public BookDto takeBook(long bookId, long userId) {
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new BookNotFoundException(bookId));
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));

        if(!book.status || book.quantity <= 0){
            throw new RuntimeException("Книга не доступна, выберите другую книгу");
        }
        if (user.getMaxBooksCount() >= 2){
            throw new RuntimeException("Нельзя брать больше 2 книг");
        }


        List<User> owners = userRepository.getOwnersByBookId(bookId);
        owners.add(user);
        user.setMaxBooksCount(user.getMaxBooksCount() + 1);
        book.setOwners(owners);
        book.setQuantity(book.getQuantity() - 1);
        if(book.quantity == 0){
            book.setStatus(false);
        }else {
            book.setStatus(true);
        }

        userRepository.save(user);
        bookRepository.save(book);
        return bookMapper.convertToDto(book);

    }

    @Override
    public BookDto returnBook(long userId, long bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new BookNotFoundException(bookId));
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
        if(user.getMaxBooksCount() <= 0){
            throw new RuntimeException("Вы еще не брали книг");
        }
        List<User> owners = userRepository.getOwnersByBookId(bookId);
        //TODO refactor and fix

        user.setMaxBooksCount(user.getMaxBooksCount() - 1);
        book.setQuantity(book. getQuantity() + 1);
        owners.remove(user);
        book.setOwners(owners);

        userRepository.save(user);
        bookRepository.save(book);
        return bookMapper.convertToDto(book);

    }
    

}
