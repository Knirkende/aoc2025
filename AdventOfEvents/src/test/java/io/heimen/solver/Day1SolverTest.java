package io.heimen.solver;

import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Day1SolverTest {

    @Test
    void solve() throws Exception {
        Day1Solver solver = new Day1Solver();
        var data = new ClassPathResource("testinput/day" + 1 + "test.txt");
        List<String> parsed;
        try (var reader = new BufferedReader(new InputStreamReader(data.getInputStream()))) {
            parsed = reader.lines().toList().stream().map(String::trim).toList();
        }
        var res = solver.solve(parsed);
        assertEquals(3, res);
        res = solver.solvePartTwo(parsed);
        assertEquals(6, res);
    }

}