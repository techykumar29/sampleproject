package commondtos.saga.event;

import java.util.Date;
import java.util.UUID;

import commondtos.saga.dto.OrderRequestDto;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class OrderEvent implements Event {

	private UUID eventId = UUID.randomUUID();
	private Date eventDate = new Date();
	private OrderRequestDto orderRequestDto;
	private OrderStatus orderStatus;

	@Override
	public UUID getEventId() {

		return eventId;
	}

	@Override
	public Date getDate() {
		return eventDate;
	}

	public OrderEvent(OrderRequestDto orderRequestDto, OrderStatus orderStatus) {
		this.orderRequestDto = orderRequestDto;
		this.orderStatus = orderStatus;
	}
	
	
}
