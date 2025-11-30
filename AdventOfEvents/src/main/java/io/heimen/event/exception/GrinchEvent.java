package io.heimen.event.exception;

import io.heimen.event.BaseEvent;

public class GrinchEvent extends BaseEvent {

    private final Throwable grinch;

    public GrinchEvent(Object source, Throwable grinch) {
        super(source);
        this.grinch = grinch;
    }

    public Throwable getGrinch() {
        return grinch;
    }

}
