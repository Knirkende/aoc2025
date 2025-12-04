package io.heimen.solver;

import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day4SolverTest {


    @Test
    void solve() throws Exception {
        Day4Solver solver = new Day4Solver();
        var data = new ClassPathResource("testinput/day" + 4 + "test.txt");
        List<String> parsed;
        try (var reader = new BufferedReader(new InputStreamReader(data.getInputStream()))) {
            parsed = reader.lines().toList().stream().map(String::trim).toList();
        }
        var res = solver.solve(parsed);
        assertEquals(13, res);
        //res = solver.solvePartTwo(parsed);
        //assertEquals(0L, res);
    }

}