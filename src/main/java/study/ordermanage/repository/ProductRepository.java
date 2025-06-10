package study.ordermanage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import study.ordermanage.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
