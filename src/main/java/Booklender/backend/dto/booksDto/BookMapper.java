package Booklender.backend.dto.booksDto;

import Booklender.backend.model.Book;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
@Component
@AllArgsConstructor
public class BookMapper {

        private ModelMapper modelMapper;

        public BookDto convertToDto(Book book){
            return modelMapper.map(book, BookDto.class);
        }


}
