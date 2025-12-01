package io.heimen.solver;

import java.util.List;

/**
 * Wow such javadoc
 */
public class Day1Solver {

    public int solve(List<String> data) {
        var dial = 50;
        var counter = 0;
        for (var line : data) {
            for (var i = 0; i < Integer.parseInt(line.substring(1)); i++) {
                dial = line.startsWith("L") ? moveLeft(dial) : moveRight(dial);
            }
            if (dial == 0) counter++;
        }
        return counter;
    }

    public int solvePartTwo(List<String> data) {
        var dial = 50;
        var counter = 0;
        for (var line : data) {
            for (var i = 0; i < Integer.parseInt(line.substring(1)); i++) {
                dial = line.startsWith("L") ? moveLeft(dial) : moveRight(dial);
                if (dial == 0) counter++;
            }
        }
        return counter;
    }

    private int moveLeft(int startPos) {
        if (startPos == 0) {
            return 99;
        }
        return startPos - 1;
    }
    private int moveRight(int startPos) {
        if (startPos == 99) {
            return 0;
        }
        return startPos + 1;
    }
}
