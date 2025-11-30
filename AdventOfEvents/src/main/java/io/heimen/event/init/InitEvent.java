package io.heimen.event.init;

import io.heimen.event.BaseEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InitEvent extends BaseEvent {

    private static final Logger logger = LoggerFactory.getLogger(InitEvent.class);

    public InitEvent(Object source) {
        super(source);
    }
}
