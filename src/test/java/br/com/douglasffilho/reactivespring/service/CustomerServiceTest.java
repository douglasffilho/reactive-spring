package br.com.douglasffilho.reactivespring.service;

import br.com.douglasffilho.reactivespring.domain.enums.Gender;
import br.com.douglasffilho.reactivespring.domain.impl.Customer;
import br.com.douglasffilho.reactivespring.repository.CustomerRepository;
import br.com.douglasffilho.reactivespring.service.impl.CustomerServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.Import;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.function.Predicate;

@DataMongoTest
@Import(CustomerServiceImpl.class)
public class CustomerServiceTest {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void shouldGetAllCustomers() {

        final Customer newCustomer1 = Customer
            .builder()
            .email("teste1@gmail.com")
            .telephone("+5511988888881")
            .gender(Gender.U)
            .build();

        final Customer newCustomer2 = Customer
            .builder()
            .email("teste2@gmail.com")
            .telephone("+5511988888882")
            .gender(Gender.U)
            .build();

        final Customer newCustomer3 = Customer
            .builder()
            .email("teste3@gmail.com")
            .telephone("+5511988888883")
            .gender(Gender.U)
            .build();

        Flux<Customer> savedOnes = customerRepository.saveAll(Flux.just(newCustomer1, newCustomer2, newCustomer3));
        Flux<Customer> found = customerService.all().thenMany(savedOnes);

        Predicate<Customer> match = customer -> savedOnes.any(saved -> saved.equals(customer)).blockOptional().isPresent();

        StepVerifier
            .create(found)
            .expectNextMatches(match)
            .expectNextMatches(match)
            .expectNextMatches(match)
            .verifyComplete();
    }

    @Test
    public void shouldCreateNewCustomer() {

    }

}
