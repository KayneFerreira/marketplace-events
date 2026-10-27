package dio.marketplace.catalog.application;

import dio.marketplace.catalog.application.dto.EventOutput;
import dio.marketplace.catalog.domain.EventRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class BrowseShowcaseUseCase {
    private static final Logger log = LoggerFactory.getLogger(BrowseShowcaseUseCase.class);

    private final EventRepository eventRepository;
    private final EventEnricher eventEnricher;

    @Cacheable(value = "showcase", unless = "#result.isEmpty()")
    public List<EventOutput> execute() {
        var future = eventRepository.findAll().stream().map(eventEnricher::enrich).toList();

        var events = future.stream()
                .map(CompletableFuture::join)
                .map(EventOutput::from)
                .toList();

        log.info("{} events enriched", events.size());

        return events;
    }

}
