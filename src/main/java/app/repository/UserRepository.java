package app.repository;

import app.entity.RedisUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<RedisUser, Long> {

    Optional<RedisUser> findByEmailIdAndPassword(String emailId, String password);

}
