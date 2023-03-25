package commondtos.saga.event;

import java.util.Date;
import java.util.UUID;

import commondtos.saga.dto.PaymentRequestDto;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class PaymentEvent implements Event {

	private UUID eventId = UUID.randomUUID();
	private Date eventDate = new Date();
	private PaymentRequestDto paymentRequestDto;
	private PaymentStatus paymentStatus;

	@Override
	public UUID getEventId() {

		return eventId;
	}

	@Override
	public Date getDate() {

		return eventDate;
	}

	public PaymentEvent(PaymentRequestDto paymentRequestDto, PaymentStatus paymentStatus) {

		this.paymentRequestDto = paymentRequestDto;
		this.paymentStatus = paymentStatus;
	}

}
