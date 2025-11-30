package io.heimen.publisher;

import io.heimen.event.exception.GrinchEvent;
import io.heimen.event.init.InitEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class ExceptionPublisher {

    private final ApplicationEventPublisher applicationEventPublisher;

    public ExceptionPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void publishExceptionEvent(Object source, int dayNumber, Throwable grinch) {
        var event = new GrinchEvent(this, dayNumber, grinch);
        applicationEventPublisher.publishEvent(event);
    }
}
