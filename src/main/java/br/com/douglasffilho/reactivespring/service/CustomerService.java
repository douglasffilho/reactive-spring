package br.com.douglasffilho.reactivespring.service;

import br.com.douglasffilho.reactivespring.domain.enums.Gender;
import br.com.douglasffilho.reactivespring.domain.impl.Customer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerService {

    Flux<Customer> all();

    Mono<Customer> getCustomerById(String id);

    Mono<Customer> getCustomerByEmail(String email);

    Mono<Customer> getCustomerByTelephone(String telephone);

    Flux<Customer> getCustomersByGender(Gender gender);

    Mono<Customer> save(Customer customer);

    Mono<Customer> deleteById(String id);
}
