package Booklender.backend.repository.identityRepository;

import Booklender.backend.model.userDetails.UsersRoles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UsersRoles, Long> {
    @Query("SELECT role FROM UsersRoles role WHERE role.name = 'USER'")
    UsersRoles getRoleUser();
}
