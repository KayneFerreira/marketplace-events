package dio.marketplace.catalog.infrastructure.event;

import dio.marketplace.catalog.infrastructure.persistence.entity.EventMetadata;
import dio.marketplace.common.infrasctructure.event.dto.EventUpdated;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.AfterDeleteEvent;
import org.springframework.data.mongodb.core.mapping.event.AfterSaveEvent;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EventMetadataEventListener extends AbstractMongoEventListener<EventMetadata> {
    private static final Logger log = LoggerFactory.getLogger(EventMetadataEventListener.class);

    private final ApplicationEventPublisher publisher;

    @Override
    public void onAfterSave(AfterSaveEvent<EventMetadata> event) {
        log.warn("CustomerEventHandler#handleAfterSave {}", event.getDocument());

        publisher.publishEvent(EventUpdated.from(event.getSource()));
    }

    @Override
    public void onAfterDelete(AfterDeleteEvent<EventMetadata> event) {
        log.warn("CustomerEventHandler#handleAfterDelete {}", event.getDocument());
    }
}
