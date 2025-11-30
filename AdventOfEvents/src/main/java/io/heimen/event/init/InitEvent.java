package io.heimen.event.init;

import io.heimen.event.BaseEvent;

public class InitEvent extends BaseEvent {

    public InitEvent(Object source, int dayNumber) {
        super(source, dayNumber);
    }
}
