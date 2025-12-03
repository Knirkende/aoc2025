package io.heimen.solver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

/**
 * Wow such javadoc
 */
public class Day3Solver {

    private static final Logger logger = LoggerFactory.getLogger(Day3Solver.class);

    public long solve(List<String> data) {
        var res = 0;
        for (var bank : data) {
            var intStr = Arrays.stream(bank.substring(0, bank.length() - 1).split("")).map(Integer::parseInt);
            int juciestBatteryPos = bank.indexOf(String.valueOf(intStr.max(Integer::compareTo).orElseThrow()));
            intStr = Arrays.stream(bank.substring(juciestBatteryPos + 1).split("")).map(Integer::parseInt);
            int secondJuciestPos = bank.indexOf(String.valueOf(intStr.max(Integer::compareTo).orElseThrow()));
            res += Integer.parseInt(String.valueOf(bank.charAt(juciestBatteryPos)) + String.valueOf(bank.charAt(secondJuciestPos)));
        }
        return res;
    }

    public long solvePartTwo(List<String> data) {
        var res = 0L;
        for (var bank : data) {
            var total = new StringBuilder();
            var juciestBatteryPos = -1;
            for (int remaining = 12; remaining > 0; remaining--) {
                var intStr = Arrays.stream(bank.substring(juciestBatteryPos + 1, bank.length() - remaining + 1).split("")).map(Integer::parseInt);
                juciestBatteryPos = bank.indexOf(String.valueOf(intStr.max(Integer::compareTo).orElseThrow()), juciestBatteryPos + 1);
                total.append(bank.charAt(juciestBatteryPos));
            }
            res += Long.parseLong(total.toString());
        }
        return res;
    }

}
