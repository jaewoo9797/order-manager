package study.ordermanage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import study.ordermanage.entity.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

}
