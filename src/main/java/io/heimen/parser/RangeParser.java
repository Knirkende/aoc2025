package io.heimen.parser;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Returns a list of lines
 */
public class RangeParser {

    public static Map<String, String> parseAsPairs(List<String> input, String delimiter) {
        var map = new HashMap<String, String>();
        Arrays.stream(input.getFirst().split(delimiter))
                .map(String::trim).forEach(r -> map.put(r.split("-")[0], r.split("-")[1]));
        return map;
    }

}
