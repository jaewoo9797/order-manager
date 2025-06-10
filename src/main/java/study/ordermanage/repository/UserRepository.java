package study.ordermanage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import study.ordermanage.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
