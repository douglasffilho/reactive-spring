package br.com.douglasffilho.reactivespring.event;

import br.com.douglasffilho.reactivespring.domain.impl.Customer;
import org.springframework.context.ApplicationEvent;

public class CustomerDeletedEvent extends ApplicationEvent {
    private static final long serialVersionUID = -726948234785762778L;

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public CustomerDeletedEvent(Customer source) {
        super(source);
    }
}
