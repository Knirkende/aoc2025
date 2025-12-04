package io.heimen.listener;

import io.heimen.event.parser.RawDataAvailableEvent;
import io.heimen.parser.RangeParser;
import io.heimen.parser.SimpleLineParser;
import io.heimen.publisher.ParserPublisher;
import org.jspecify.annotations.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ParserListener implements ApplicationListener<@NonNull RawDataAvailableEvent> {

    private static final Logger logger = LoggerFactory.getLogger(ParserListener.class);
    private final ParserPublisher parserPublisher;

    public ParserListener(ParserPublisher parserPublisher) {
        this.parserPublisher = parserPublisher;
    }

    @Override
    public void onApplicationEvent(RawDataAvailableEvent event) {
        logger.info("Unparsed stuff encountered of length: {}", event.getRawLines().size());
        Object res = switch (event.getDayNum()) {
            case 1, 3, 4 -> SimpleLineParser.parseAsList(event.getRawLines());
            case 2 -> RangeParser.parseAsPairs(event.getRawLines(), ",");
            default -> throw new IllegalArgumentException("Invalid day number");
        };
        parserPublisher.publishDataAvailableEvent(event.getSource(), event.getDayNum(), Map.of("data", res));
    }
}
