package io.heimen.listener;

import io.heimen.event.init.InitEvent;
import io.heimen.publisher.ParserPublisher;
import org.jspecify.annotations.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class InitListener implements ApplicationListener<@NonNull InitEvent> {

    private static final Logger logger = LoggerFactory.getLogger(InitListener.class);
    private final ParserPublisher parserPublisher;

    public InitListener(ParserPublisher parserPublisher) {
        this.parserPublisher = parserPublisher;
    }

    @Override
    public void onApplicationEvent(InitEvent event) {
        logger.info("... and the listener listened.");
        parserPublisher.publishRawDataAvailableEvent(this, event.getDayNum());
    }
}
