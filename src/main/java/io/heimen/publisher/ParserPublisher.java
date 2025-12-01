package io.heimen.publisher;

import io.heimen.event.parser.DataAvailableEvent;
import io.heimen.event.parser.RawDataAvailableEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

@Component
public class ParserPublisher {

    private final ApplicationEventPublisher applicationEventPublisher;

    public ParserPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void publishRawDataAvailableEvent(Object source, int dayNumber) {
        try {
            var res = new ClassPathResource("input/day" + dayNumber + ".txt");
            List<String> rawData;
            try (var reader = new BufferedReader(new InputStreamReader(res.getInputStream()))) {
                rawData = reader.lines().toList();
            }
            var event = new RawDataAvailableEvent(source, dayNumber, rawData);
            applicationEventPublisher.publishEvent(event);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void publishDataAvailableEvent(Object source, int dayNumber, Map<String, Object> data) {
        var event = new DataAvailableEvent(source, dayNumber, data);
        applicationEventPublisher.publishEvent(event);
    }

}
