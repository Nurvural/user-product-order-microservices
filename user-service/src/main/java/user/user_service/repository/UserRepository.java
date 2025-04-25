package user.user_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import user.user_service.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}

