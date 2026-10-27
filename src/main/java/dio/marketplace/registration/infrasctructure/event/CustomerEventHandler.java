package dio.marketplace.registration.infrasctructure.event;

import dio.marketplace.common.infrasctructure.event.dto.CustomerCreated;
import dio.marketplace.registration.infrasctructure.persistence.entity.CustomerEntity;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.HandleAfterDelete;
import org.springframework.data.rest.core.annotation.HandleAfterSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

@Component
@RepositoryEventHandler
@RequiredArgsConstructor
public class CustomerEventHandler {
    private static final Logger log = LoggerFactory.getLogger(CustomerEventHandler.class);

    private final ApplicationEventPublisher publisher;

    @HandleAfterCreate
    public void handleAfterCreate(CustomerEntity customerEntity) {
        log.warn("CustomerEventHandler#handleAfterCreate");
        publisher.publishEvent(new CustomerCreated(customerEntity.getId().toString(), customerEntity.getFirstName()));
    }

    @HandleAfterSave
    public void handleAfterSave(CustomerEntity customerEntity) {
        log.warn("CustomerEventHandler#handleAfterSave");
    }

    @HandleAfterDelete
    public void handleAfterDelete(CustomerEntity customerEntity) {
        log.warn("CustomerEventHandler#handleAfterDelete");
    }
}
