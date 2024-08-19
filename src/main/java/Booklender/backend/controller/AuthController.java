package Booklender.backend.controller;

import Booklender.backend.dto.userDto.AuthRequest;
import Booklender.backend.dto.userDto.AuthResponse;
import Booklender.backend.service.identityService.IdentityService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final IdentityService identityService;

    // ------------------------------
    @PostMapping("/register")
    // ------------------------------
    @Operation(summary = "User registration", description = "Login user  (Get JWT token)")
    public ResponseEntity<AuthResponse> register(@RequestBody AuthRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(identityService.registerUser(request));
    }

    // ------------------------------
    @PostMapping("/login")
    // ------------------------------
    @Operation(summary = "User authentication", description = "Login user  (Get JWT token)")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest authRequest) {
        return ResponseEntity.ok(identityService.login(authRequest));
    }

    // ------------------------------
    @PostMapping("/logout")
    // ------------------------------
    @Operation(summary = "User logout", description = "Logout user")
    public ResponseEntity<AuthResponse> logout(@RequestParam String token) {
        return ResponseEntity.ok(identityService.logout(token));
    }

    // ------------------------------
    @GetMapping("/refresh-token")
    @Operation(summary = "Refresh   token", description = "Get access token by refresh token")
    // ------------------------------
    public ResponseEntity<?> refreshToken(@RequestHeader("Authorization") String authHeaderValue) {

        if (authHeaderValue != null && authHeaderValue.startsWith("Bearer")) {
            return ResponseEntity.ok(identityService.refreshToken(authHeaderValue.substring(7)));
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(null);
    }
}
