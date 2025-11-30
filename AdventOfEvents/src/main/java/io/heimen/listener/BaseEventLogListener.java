package io.heimen.listener;

import io.heimen.event.BaseEvent;
import org.jspecify.annotations.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class BaseEventLogListener implements ApplicationListener<@NonNull BaseEvent> {

    private static final Logger logger = LoggerFactory.getLogger(BaseEventLogListener.class);

    @Override
    public void onApplicationEvent(BaseEvent event) {
        logger.info("Logging listener intercepted an event of type {}", event.getEventTypeIdentifier());
    }
}
