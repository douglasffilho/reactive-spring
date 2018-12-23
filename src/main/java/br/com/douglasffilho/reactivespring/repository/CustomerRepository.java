package br.com.douglasffilho.reactivespring.repository;

import br.com.douglasffilho.reactivespring.domain.enums.Gender;
import br.com.douglasffilho.reactivespring.domain.impl.Customer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerRepository extends ReactiveMongoRepository<Customer, String> {

    Mono<Customer> findByEmail(String email);

    Mono<Customer> findByTelephone(String telephone);

    Flux<Customer> findByGender(Gender gender);

}
