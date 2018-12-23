package br.com.douglasffilho.reactivespring.event;

import br.com.douglasffilho.reactivespring.domain.impl.Customer;
import org.springframework.context.ApplicationEvent;

public class CustomerCreatedEvent extends ApplicationEvent {
    private static final long serialVersionUID = 6855527290546840848L;

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public CustomerCreatedEvent(Customer source) {
        super(source);
    }
}
