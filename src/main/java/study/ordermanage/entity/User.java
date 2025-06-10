package study.ordermanage.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import study.ordermanage.entity.base.BaseUpdatableEntity;

@Entity
@Table(name = "users")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseUpdatableEntity {

	@Column(length = 50, nullable = false, name = "name")
	private String name;

	public User(String name) {
		this.name = name;
	}
}
