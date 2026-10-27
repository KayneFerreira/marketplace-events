package dio.marketplace.ticketing.infrastructure.persistence.repository.jpa;

import dio.marketplace.ticketing.infrastructure.persistence.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

@RepositoryRestResource(exported = false, path = "_customer")
public interface CustomerCrudRepository extends JpaRepository<CustomerEntity, UUID> {

}
