package io.heimen.solver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Wow such javadoc
 */
public class Day3Solver {

    private static final Logger logger = LoggerFactory.getLogger(Day3Solver.class);

    public long solve(List<String> data) {
        var res = 0;
        for (var bank : data) {
            var intStr = Arrays.stream(bank.substring(0, bank.length() - 1).split("")).map(Integer::parseInt);
            int juciestBatteryPos = bank.indexOf(String.valueOf(intStr.max(Integer::compareTo).get()));
            intStr = Arrays.stream(bank.substring(juciestBatteryPos + 1).split("")).map(Integer::parseInt);
            int secondJuciestPos = bank.indexOf(String.valueOf(intStr.max(Integer::compareTo).get()));
            res += Integer.parseInt(String.valueOf(bank.charAt(juciestBatteryPos)) + String.valueOf(bank.charAt(secondJuciestPos)));
        }
        return res;
    }


    public long solvePartTwo(Map<String, String> data) {

        return 0;
    }

}
