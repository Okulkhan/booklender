package Booklender.backend.controller;

import Booklender.backend.dto.booksDto.BookDto;
import Booklender.backend.service.bookService.BookService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    @GetMapping("/all")
    public List<BookDto> getAll(){
        return bookService.getAll();
    }


    @PostMapping("/take/{bookId}/{userId}")
    public BookDto takeBook(@PathVariable long bookId,
                            @PathVariable long userId){
        return bookService.takeBook(bookId, userId);
    }

    @PostMapping("/return/{userId}/{bookId}")
    public BookDto returnBook(@PathVariable long userId,
                              @PathVariable long bookId){
        return bookService.returnBook(userId,bookId);
    }
}
