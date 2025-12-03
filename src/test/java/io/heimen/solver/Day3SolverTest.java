package io.heimen.solver;

import io.heimen.parser.RangeParser;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day3SolverTest {


    @Test
    void solve() throws Exception {
        Day3Solver solver = new Day3Solver();
        var data = new ClassPathResource("testinput/day" + 3 + "test.txt");
        List<String> parsed;
        try (var reader = new BufferedReader(new InputStreamReader(data.getInputStream()))) {
            parsed = reader.lines().toList().stream().map(String::trim).toList();
        }
        var res = solver.solve(parsed);
        assertEquals(357, res);
        res = solver.solvePartTwo(parsed);
        assertEquals(3121910778619L, res);
    }

}