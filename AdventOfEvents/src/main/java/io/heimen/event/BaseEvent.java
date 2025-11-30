package io.heimen.event;

import org.springframework.context.ApplicationEvent;

public abstract class BaseEvent extends ApplicationEvent {

    public BaseEvent(Object source) {
        super(source);
    }

    public String getEventTypeIdentifier() {
        return this.getClass().getSimpleName();
    }

}
