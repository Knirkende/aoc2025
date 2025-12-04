package io.heimen.solver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Wow such javadoc
 */
public class Day4Solver {

    private static final Logger logger = LoggerFactory.getLogger(Day4Solver.class);

    public long solve(List<String> data) {
        var res = 0;
        List<List<Integer>> floorPlan = new ArrayList<>();
        List<Integer> wall = new ArrayList<>();
        for (var i = 0; i < data.size() + 2; i++) {
            wall.add(0);
        }
        floorPlan.add(wall);
        for (var row : data) {
            var mapRow = new ArrayList<Integer>();
            mapRow.add(0);
            Arrays.stream(row.split("")).map(shelf -> "@".equals(shelf) ? 1 : 0).forEach(mapRow::add);
            mapRow.add(0);
            floorPlan.add(mapRow);
        }
        floorPlan.add(wall);

        for (int y = 1; y < data.size() + 1; y++) {
            for (int x = 1; x < data.getFirst().length() + 1; x++) {
                if (floorPlan.get(y).get(x) > 0 && countNeighbors(floorPlan, x, y) < 4) {
                    res++;
                }
            }
        }

        return res;
    }

    private int countNeighbors(List<List<Integer>> floorPlan, int x, int y) {
        //row above
        var res = floorPlan.get(y+1).get(x+1);
        res += floorPlan.get(y+1).get(x);
        res += floorPlan.get(y+1).get(x-1);
        //same row
        res += floorPlan.get(y).get(x-1);
        res += floorPlan.get(y).get(x+1);
        //row below
        res += floorPlan.get(y-1).get(x+1);
        res += floorPlan.get(y-1).get(x);
        res += floorPlan.get(y-1).get(x-1);

        return res;

    }

    public long solvePartTwo(List<String> data) {
        var res = 0L;
        return res;
    }

}
