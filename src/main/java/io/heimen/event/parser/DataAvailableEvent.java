package io.heimen.event.parser;

import io.heimen.event.BaseEvent;

import java.util.List;
import java.util.Map;

public class DataAvailableEvent extends BaseEvent {

    private Map<String, Object> parsedData;

    public DataAvailableEvent(Object source, int dayNumber, Map<String, Object> parsedData) {
        super(source, dayNumber);
        this.parsedData = parsedData;
    }

    public Object getParsedData() {
        return parsedData;
    }

    public Map<String, Object> getRawLines() {
        return parsedData;
    }

}
