package atmPackages.repositories;

import java.util.UUID;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import atmPackages.model.Users;


@Repository
public interface UserRepository extends JpaRepository<Users, UUID>{

	ResponseEntity<String> save = null;

}
