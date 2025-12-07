package io.heimen.parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Returns a list of lines
 */
public class Map2dParser {

    public static List<List<String>> parseAs2dMap(List<String> input, String delimiter) {
        return input.stream()
                .map(x -> Arrays.stream(x.split(delimiter))
                        .map(String::trim)
                        .collect(Collectors.toCollection(ArrayList::new)))
                .collect(Collectors.toCollection(ArrayList::new));

    }

}
