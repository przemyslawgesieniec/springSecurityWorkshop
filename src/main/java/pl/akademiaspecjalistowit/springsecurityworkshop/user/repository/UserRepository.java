package pl.akademiaspecjalistowit.springsecurityworkshop.user.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.akademiaspecjalistowit.springsecurityworkshop.user.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByUsername(String username);
}