package io.heimen.parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Returns a list of lines
 */
public class SimpleLineParser {

    public static List<String> parseAsList(List<String> input) {
        return input.stream().map(String::trim).collect(Collectors.toCollection(ArrayList::new));
    }

    public static List<String> parseAsListNoTrim(List<String> input) {
        return new ArrayList<>(input);
    }

    public static List<String> parseAsList(List<String> input, String delimiter) {
        return Arrays.stream(input.getFirst().split(delimiter)).map(String::trim).toList();
    }
}
