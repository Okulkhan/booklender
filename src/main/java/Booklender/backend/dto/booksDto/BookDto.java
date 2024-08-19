package Booklender.backend.dto.booksDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDto {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private long id;

    public String name;

    public String author;

    public String imageIRL;

    public int quantity;

    public boolean status;


}
