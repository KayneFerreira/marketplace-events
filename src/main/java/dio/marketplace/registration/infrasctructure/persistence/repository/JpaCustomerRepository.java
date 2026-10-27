package dio.marketplace.registration.infrasctructure.persistence.repository;

import dio.marketplace.common.infrasctructure.event.dto.CustomerCreated;
import dio.marketplace.registration.domain.Customer;
import dio.marketplace.registration.domain.CustomerId;
import dio.marketplace.registration.domain.CustomerRepository;
import dio.marketplace.registration.infrasctructure.persistence.entity.CustomerEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class JpaCustomerRepository implements CustomerRepository {
    private final CustomerEntityRepository customerRepository;
    private final ApplicationEventPublisher publisher;

    @Override
    public Customer save(Customer customer) {
        var entity = mapper(customer);
        var savedEntity = customerRepository.save(entity);

        publisher.publishEvent(new CustomerCreated(customer.getId().id().toString(), customer.getName()));

        return mapper(savedEntity);
    }

    @Override
    public List<Customer> findAll() {
        var list = customerRepository.findAll();
        return list.stream().map(JpaCustomerRepository::mapper).toList();
    }


    private static CustomerEntity mapper(Customer customer) {
        var entity = new CustomerEntity();
        entity.setId(customer.getId().id());
        entity.setFirstName(customer.getName());
        entity.setEmail(customer.getEmail());
        return entity;
    }


    private static Customer mapper(CustomerEntity entity) {
        var customer = new Customer();
        String fullName = entity.getFirstName() + " " + entity.getLastName();
        customer.setId(new CustomerId(entity.getId()));
        customer.setName(fullName);
        customer.setEmail(entity.getEmail());
        return customer;
    }
}
