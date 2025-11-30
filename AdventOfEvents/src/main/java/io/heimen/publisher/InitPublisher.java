package io.heimen.publisher;

import io.heimen.event.init.InitEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class InitPublisher {

    private final ApplicationEventPublisher applicationEventPublisher;

    public InitPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void publishInitEvent(Object source, int dayNumber) {
        var event = new InitEvent(source, dayNumber);
        applicationEventPublisher.publishEvent(event);
    }
}
