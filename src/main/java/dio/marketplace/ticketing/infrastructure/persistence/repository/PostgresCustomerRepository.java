package dio.marketplace.ticketing.infrastructure.persistence.repository;

import dio.marketplace.ticketing.domain.Customer;
import dio.marketplace.ticketing.domain.CustomerRepository;
import dio.marketplace.ticketing.infrastructure.persistence.entity.CustomerEntity;
import dio.marketplace.ticketing.infrastructure.persistence.repository.jpa.CustomerCrudRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PostgresCustomerRepository implements CustomerRepository {
    private final CustomerCrudRepository customerRepository;

    @Override
    public void save(Customer customer) {
        var entity = new CustomerEntity(
                customer.getId(),
                customer.getCorrelationId().id(),
                customer.getName()
        );
        customerRepository.save(entity);
    }
}
