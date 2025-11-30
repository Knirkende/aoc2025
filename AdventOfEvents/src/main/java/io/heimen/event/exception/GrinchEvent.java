package io.heimen.event.exception;

import org.springframework.context.ApplicationEvent;

public class GrinchEvent extends ApplicationEvent {

    private final Throwable grinch;

    public GrinchEvent(Object source, Throwable grinch) {
        super(source);
        this.grinch = grinch;
    }

    public Throwable getGrinch() {
        return grinch;
    }

}
