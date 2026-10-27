package dio.marketplace.ticketing.infrastructure.persistence.repository.jpa;

import dio.marketplace.ticketing.infrastructure.persistence.entity.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

@RepositoryRestResource(exported = false, path = "_event")
public interface EventCrudRepository extends JpaRepository<EventEntity, UUID> {
    boolean existsByCorrelationIdAndSectors_Seats_CorrelationId(UUID eventId, String seatId);
}
