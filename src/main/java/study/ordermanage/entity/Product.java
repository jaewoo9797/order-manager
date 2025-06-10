package study.ordermanage.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import study.ordermanage.entity.base.BaseUpdatableEntity;

@Entity
@Table(name = "products")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product extends BaseUpdatableEntity {

	@Column(name = "name", nullable = false, length = 200)
	private String name;

	@Column(name = "category", length = 100)
	private String category;

	@Column(name = "price", nullable = false)
	private Long price;

	@Column(name = "description", columnDefinition = "text")
	private String description;

	@Builder
	public Product(String name, String category, Long price, String description) {
		this.name = name;
		this.category = category;
		this.price = price;
		this.description = description;
	}
}
