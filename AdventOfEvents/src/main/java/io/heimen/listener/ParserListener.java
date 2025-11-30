package io.heimen.listener;

import io.heimen.event.init.InitEvent;
import io.heimen.event.parser.ParseEvent;
import io.heimen.publisher.ParserPublisher;
import org.jspecify.annotations.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ParserListener implements ApplicationListener<@NonNull ParseEvent> {

    private static final Logger logger = LoggerFactory.getLogger(ParserListener.class);

    @Override
    public void onApplicationEvent(ParseEvent event) {
        logger.info("Unparsed stuff: {}", event.getRawLines());
    }
}
