package dio.marketplace.registration.infrasctructure.persistence.repository;

import dio.marketplace.registration.infrasctructure.persistence.entity.CustomerEntity;
import dio.marketplace.registration.infrasctructure.persistence.entity.projection.CustomerExcerpt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;
import java.util.UUID;

@RepositoryRestResource(path = "customers", excerptProjection = CustomerExcerpt.class)
public interface CustomerEntityRepository extends JpaRepository<CustomerEntity, UUID> {

    List<CustomerEntity> findByFirstNameStartingWithIgnoreCase(@Param("firstName") String firstName);

    @Override
    @RestResource(exported = false)     // Impede a ação de deletar um cliente
    void deleteById(UUID id);
}
