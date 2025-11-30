package io.heimen.publisher;

import io.heimen.event.init.InitEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class InitPublisher {

    private final ApplicationEventPublisher applicationEventPublisher;

    public InitPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void publishInitEvent(Object source) {
        var event = new InitEvent(source);
        applicationEventPublisher.publishEvent(event);
    }
}
