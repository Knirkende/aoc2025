package io.heimen.solver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class Day7Solver {
    private static final Logger logger = LoggerFactory.getLogger(Day7Solver.class);
    private static final String TACHYON_SOURCE = "S";
    private static final String SPLITTER = "^";
    private static final String CHANNEL = ".";
    private static final String BEAM = "|";

    public Day7Solver() {

    }

    public long solve(List<List<String>> data) {
        var res = 0L;

        var tachyonSource = data.getFirst().indexOf(TACHYON_SOURCE);

        res = propagateTachyon(data, 1, tachyonSource, res);

        return res;
    }

    private long propagateTachyon(List<List<String>> map, int yPos, int xPos, long counter) {
        if (xPos < 0 || xPos >= map.getFirst().size() || yPos > map.getLast().size()) {
            return counter;
        }
        if (SPLITTER.equals(map.get(yPos).get(xPos))) {
            counter = propagateTachyon(map, yPos + 1, xPos - 1, counter);
            counter = propagateTachyon(map, yPos + 1, xPos + 1, counter);
            counter ++;
        } else if (CHANNEL.equals(map.get(yPos).get(xPos))) {
            map.get(yPos).set(xPos, BEAM);
            counter = propagateTachyon(map, yPos + 1, xPos, counter);
        }

        return counter;
    }

    public long solvePartTwo(List<List<String>> data) {
        var res = 0L;

        List<List<Integer>> worldMap = new ArrayList<>();
        for (List<String> r : data) {
            var row = new ArrayList<Integer>();
            for (int j = 0; j < r.size(); j++) {
                row.add(0);
            }
            worldMap.add(row);
        }

        //DP problem


        return res;
    }

}
