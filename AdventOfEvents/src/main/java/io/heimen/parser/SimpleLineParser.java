package io.heimen.parser;

import java.util.List;

/**
 * Returns a list of lines
 */
public class SimpleLineParser {

    public static List<String> parseAsList(List<String> input) {
        return input.stream().map(String::trim).toList();
    }

}
