package dio.marketplace.catalog.application;

import dio.marketplace.catalog.domain.Event;
import dio.marketplace.catalog.domain.EventMetadataRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class EventEnricher {
    private static final Logger log = LoggerFactory.getLogger(EventEnricher.class);

    private final EventMetadataRepository eventMetadataRepository;

    @Async
    public CompletableFuture<Event> enrich(Event event) {
        log.info("Enriching event: {}", event);

        var metadata = eventMetadataRepository.findByEventId(event.getId());
        event.setMetadata(metadata);

        return CompletableFuture.completedFuture(event);
    }
}
