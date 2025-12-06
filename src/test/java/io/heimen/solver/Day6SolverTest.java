package io.heimen.solver;

import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day6SolverTest {

    @Test
    void solve() throws Exception {


        var data = new ClassPathResource("testinput/day" + 6 + "test.txt");
        List<String> parsed;
        try (var reader = new BufferedReader(new InputStreamReader(data.getInputStream()))) {
            parsed = new ArrayList<>(reader.lines().toList());
        }
        var solver = new Day6Solver();
        var res = solver.solve(parsed);
        assertEquals(4277556, res);
        res = solver.solvePartTwo(parsed);
        assertEquals(3263827, res);
    }

}