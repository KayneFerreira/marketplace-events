package dio.marketplace.catalog.infrastructure.persistence.repository;

import dio.marketplace.catalog.infrastructure.persistence.entity.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

@RepositoryRestResource(path = "events")
public interface EventEntityRepository extends JpaRepository<EventEntity, UUID> {
}
