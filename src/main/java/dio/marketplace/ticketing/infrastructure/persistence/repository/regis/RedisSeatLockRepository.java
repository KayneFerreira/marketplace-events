package dio.marketplace.ticketing.infrastructure.persistence.repository.regis;

import dio.marketplace.ticketing.infrastructure.persistence.entity.SeatLock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource(exported = false)
public interface RedisSeatLockRepository extends JpaRepository<SeatLock, String> {
    Optional<SeatLock> findByCustomerId(String customerId);
}
