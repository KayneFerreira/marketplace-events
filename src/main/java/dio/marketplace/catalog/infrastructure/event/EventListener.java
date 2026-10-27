package dio.marketplace.catalog.infrastructure.event;

import dio.marketplace.catalog.infrastructure.persistence.entity.EventEntity;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostRemove;
import jakarta.persistence.PostUpdate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EventListener {

    private static final Logger log = LoggerFactory.getLogger(EventListener.class);

    @PostPersist
    public void onEventCreated(EventEntity event) {
        log.info("Event created via @PostPersist {}", event);
    }

    @PostUpdate
    public void onEventpdated(EventEntity event) {
        log.info("Event updated via @PostPersist {}", event);
    }

    @PostRemove
    public void onEventDeleted(EventEntity event) {
        log.info("Event removed via @PostPersist {}", event);
    }
}
