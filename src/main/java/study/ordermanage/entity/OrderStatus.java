package study.ordermanage.entity;

public enum OrderStatus {
	PENDING,    // 주문 대기 중
	PROCESSING, // 주문 처리 중
	SHIPPED,    // 배송 중
	DELIVERED,  // 배송 완료
	CANCELLED   // 주문 취소됨
}
