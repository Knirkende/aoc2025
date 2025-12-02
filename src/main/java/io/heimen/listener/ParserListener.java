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
        switch (event.getDayNum()) {
            case 1:
                var res = SimpleLineParser.parseAsList(event.getRawLines());
                parserPublisher.publishDataAvailableEvent(event.getSource(), event.getDayNum(), Map.of("data", res));
                break;
            case 2:
                var res2 = RangeParser.parseAsPairs(event.getRawLines(), ",");
                parserPublisher.publishDataAvailableEvent(event.getSource(), event.getDayNum(), Map.of("data", res2));
                break;
            default:
                break;
        }
    }
}
