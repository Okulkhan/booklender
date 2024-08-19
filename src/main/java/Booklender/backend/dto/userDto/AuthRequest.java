package Booklender.backend.dto.userDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AuthRequest {

    private String email;
    private String password;
    private String name;
    private String surname;
    private String patronymic;

}