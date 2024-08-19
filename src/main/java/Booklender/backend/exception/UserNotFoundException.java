package Booklender.backend.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(Long userId) {
        super("Пользователь с таким ID " + userId + " не найден");
    }
}