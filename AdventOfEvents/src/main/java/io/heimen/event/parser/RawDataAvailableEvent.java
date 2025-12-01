package io.heimen.event.parser;

import io.heimen.event.BaseEvent;

import java.util.List;

public class RawDataAvailableEvent extends BaseEvent {

    private Object parsedData;
    private List<String> rawLines;

    public RawDataAvailableEvent(Object source, int dayNumber, List<String> rawLines) {
        super(source, dayNumber);
        this.rawLines = rawLines;
    }

    public Object getParsedData() {
        return parsedData;
    }

    public List<String> getRawLines() {
        return rawLines;
    }

}
