package dio.marketplace.catalog.infrastructure.persistence.repository;

import dio.marketplace.catalog.domain.Event;
import dio.marketplace.catalog.domain.EventId;
import dio.marketplace.catalog.domain.EventRepository;
import dio.marketplace.catalog.infrastructure.persistence.entity.EventEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class JpaEventRepository implements EventRepository {
    private final EventEntityRepository eventEntityRepository;

    @Override
    public List<Event> findAll() {
        var list = eventEntityRepository.findAll();
        return list.stream().map(JpaEventRepository::toEventMapper).toList();
    }

    private static Event toEventMapper(EventEntity eventEntity) {
        var event = new Event();
        event.setId(new EventId(eventEntity.getId()));
        event.setTitle(eventEntity.getTitle());
        event.setDate(eventEntity.getDate());
        event.setMetadata(Optional.empty());
        return event;
    }
}
