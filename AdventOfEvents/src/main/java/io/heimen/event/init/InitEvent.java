package io.heimen.event.init;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;

public class InitEvent extends ApplicationEvent {

    private static final Logger logger = LoggerFactory.getLogger(InitEvent.class);

    public InitEvent(Object source, String message) {
        super(source);
        logger.info("An event! From {}, with msg: {}", source.getClass().getSimpleName(), message);
    }
}
