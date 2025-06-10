package study.ordermanage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import study.ordermanage.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
