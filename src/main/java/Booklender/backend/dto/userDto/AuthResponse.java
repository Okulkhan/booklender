package Booklender.backend.dto.userDto;

import Booklender.backend.model.userDetails.UsersRoles;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class AuthResponse {

    public AuthResponse(long userId, String email, String accessToken, String refreshToken, List<UsersRoles> roles) {
        this.userId = userId;
        this.email = email;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.roles = roles;
    }

    private long userId;

    private String email;

    private String accessToken;

    private String refreshToken;

    private List<UsersRoles> roles;

    private String tokenType = "Bearer";
}
