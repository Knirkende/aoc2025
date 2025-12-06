package io.heimen.solver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class Day6Solver {
    private static final Logger logger = LoggerFactory.getLogger(Day6Solver.class);

    public Day6Solver() {

    }

    public long solve(List<String> data) {
        var res = 0L;
        data = data.stream().map(String::trim).collect(Collectors.toCollection(ArrayList::new));
        var operators = data.removeLast().replaceAll("\\s+", ",").split(",");
        var results = new ArrayList<Long>();
        for (var lineOfData : data) {
            var pts = Arrays.stream(lineOfData.replaceAll("\\s+", ",").split(",")).map(Long::parseLong).toList();
            if (results.isEmpty()) {
                results.addAll(pts);
                continue;
            }
            for (int i = 0; i < pts.size(); i++) {
                if (operators[i].equals("+")) {
                    results.set(i, results.get(i) + pts.get(i));
                } else {
                    results.set(i, results.get(i) * pts.get(i));
                }
            }
        }
        res = results.stream().reduce(0L, Long::sum);
        return res;
    }

    public long solvePartTwo(List<String> data) {
        var res = 0L;
        List<List<String>> matrix = new ArrayList<>();
        var operators = data.removeLast().replaceAll("\\s+", ",").split(",");
        for (var lineOfData : data) {
            matrix.add(Arrays.stream(lineOfData.split("")).collect(Collectors.toCollection(ArrayList::new)));
        }
        var transposed = transpose(matrix);
        var deParsed = transposed.stream().map(i -> String.join("", i)).collect(Collectors.toCollection(ArrayList::new));
        var operatorLoc = 0;
        var groupRes = 0L;
        for (var num : deParsed) {
            if (num.isBlank()) {
                operatorLoc++;
                res += groupRes;
                groupRes = 0;
                continue;
            }
            num = num.strip();
            if (operators[operatorLoc].equals("+")) {
                groupRes += Long.parseLong(num);
            } else {
                groupRes = groupRes == 0 ? Long.parseLong(num) : groupRes * Long.parseLong(num);
            }
        }
        res += groupRes;

        return res;
    }

    private static List<List<String>> transpose(List<List<String>> originalList) {
        if (originalList == null || originalList.isEmpty()) {
            return new ArrayList<>();
        }

        int numRows = originalList.size();
        int numCols = originalList.getFirst().size();

        for (var row : originalList) {
            numCols = Math.max(numCols, row.size());
        }

        for (var row : originalList) {
            while (row.size() < numCols) {
                row.add(" ");
            }
        }

        List<List<String>> transposedList = new ArrayList<>(numCols);

        for (int i = 0; i < numCols; i++) {
            transposedList.add(new ArrayList<>(numRows));
        }

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                transposedList.get(j).add(originalList.get(i).get(j));
            }
        }
        return transposedList;
    }
}
