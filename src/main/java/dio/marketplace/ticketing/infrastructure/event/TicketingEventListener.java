package dio.marketplace.ticketing.infrastructure.event;

import dio.marketplace.common.infrasctructure.event.dto.CustomerCreated;
import dio.marketplace.common.infrasctructure.event.dto.EventUpdated;
import dio.marketplace.ticketing.application.CreateCustomerUseCase;
import dio.marketplace.ticketing.application.CreateEventUseCase;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TicketingEventListener {
    public static final Logger log = LoggerFactory.getLogger(TicketingEventListener.class);

    private final CreateCustomerUseCase createCustomerUseCase;
    private final CreateEventUseCase createEventUseCase;

    @EventListener
    @Async
    public void handle(CustomerCreated event) {
        log.info("CustomerCreated received {}", event);
        createCustomerUseCase.execute(event);
    }

    @EventListener
    @Async
    public void handle(EventUpdated event) {
        log.info("EventUpdated received {}", event);
        createEventUseCase.execute(event);
    }
}
