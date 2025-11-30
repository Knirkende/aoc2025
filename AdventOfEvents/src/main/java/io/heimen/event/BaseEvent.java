package io.heimen.event;

import org.springframework.context.ApplicationEvent;

public abstract class BaseEvent extends ApplicationEvent {

    private final int dayNum;

    public BaseEvent(Object source, int dayNumber) {
        super(source);
        this.dayNum = dayNumber;
    }

    public String getEventTypeIdentifier() {
        return this.getClass().getSimpleName();
    }

    public int getDayNum() {
        return this.dayNum;
    }

}
