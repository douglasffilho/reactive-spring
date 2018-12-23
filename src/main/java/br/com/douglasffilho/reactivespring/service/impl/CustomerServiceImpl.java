package br.com.douglasffilho.reactivespring.service.impl;

import br.com.douglasffilho.reactivespring.domain.enums.Gender;
import br.com.douglasffilho.reactivespring.domain.impl.Customer;
import br.com.douglasffilho.reactivespring.event.CustomerCreatedEvent;
import br.com.douglasffilho.reactivespring.event.CustomerDeletedEvent;
import br.com.douglasffilho.reactivespring.repository.CustomerRepository;
import br.com.douglasffilho.reactivespring.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private ApplicationEventPublisher publisher;

    @Autowired
    private CustomerRepository repository;

    @Override
    public Flux<Customer> all() {
        return repository.findAll();
    }

    @Override
    public Mono<Customer> getCustomerById(String id) {
        return repository.findById(id);
    }

    @Override
    public Mono<Customer> getCustomerByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public Mono<Customer> getCustomerByTelephone(String telephone) {
        return repository.findByTelephone(telephone);
    }

    @Override
    public Flux<Customer> getCustomersByGender(Gender gender) {
        return repository.findByGender(gender);
    }

    @Override
    public Mono<Customer> save(Customer customer) {
        return repository.save(customer)
            .doOnSuccess(savedCustomer -> publisher.publishEvent(new CustomerCreatedEvent(savedCustomer)));
    }

    @Override
    public Mono<Customer> deleteById(String id) {
        return repository
            .findById(id)
            .flatMap(customer -> repository.deleteById(customer.getId()).thenReturn(customer))
            .doOnSuccess(deletedCustomer -> publisher.publishEvent(new CustomerDeletedEvent(deletedCustomer)));
    }
}
