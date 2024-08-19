package Booklender.backend.repository.identityRepository;

import Booklender.backend.model.userDetails.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

//    @Query("""
//            SELECT u
//            FROM User u
//            LEFT JOIN u.roles r ON r.
//            WHERE u.id = :id
//
//            """)
//    Optional<User> getUserWithRoleById(long id);
    Optional<User> getByEmail(String email);

    @Query("""
        SELECT u
        FROM User u
        LEFT JOIN FETCH u.books b
        WHERE b.id = :bookId
""")
    List<User> getOwnersByBookId(long bookId);
}
