package study.ordermanage.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import study.ordermanage.entity.base.BaseUpdatableEntity;

@AttributeOverride(
	name = "updatedAt",
	column = @Column(name = "last_updated", columnDefinition = "timestamp with time zone")
)
@Entity
@Table(name = "inventories")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Inventory extends BaseUpdatableEntity {

	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	@JoinColumn(name = "product_id")
	private Product product;

	@Column(name = "quantity", nullable = false)
	private Integer quantity;

	@Column(name = "safety_stock", nullable = false)
	private Integer safetyStock;

	@Builder
	public Inventory(Product product, Integer quantity, Integer safetyStock) {
		this.product = product;
		this.quantity = quantity;
		this.safetyStock = safetyStock;
	}
}
