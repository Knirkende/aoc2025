package io.heimen.event;

import io.heimen.event.init.InitEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class InitPublisher {

    private final ApplicationEventPublisher applicationEventPublisher;

    public InitPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void publishInitEvent(Object source, String message) {
        var event = new InitEvent(source, message);
        applicationEventPublisher.publishEvent(event);
    }
}
