package Booklender.backend.dto.userDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Request {

    private String email;
    private String password;

}
