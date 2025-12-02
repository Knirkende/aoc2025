package io.heimen.solver;

import io.heimen.parser.RangeParser;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day2SolverTest {


    @Test
    void solve() throws Exception {
        Day2Solver solver = new Day2Solver();
        var data = new ClassPathResource("testinput/day" + 2 + "test.txt");
        Map<String, String> parsed;
        try (var reader = new BufferedReader(new InputStreamReader(data.getInputStream()))) {
            var raw = reader.lines().toList().stream().map(String::trim).toList();
            parsed = RangeParser.parseAsPairs(raw, ",");
        }
        var res = solver.solve(parsed);
        assertEquals(1227775554L, res);
        res = solver.solvePartTwo(parsed);
        assertEquals(4174379265L, res);
    }

}