package io.heimen.solver;

import io.heimen.parser.Map2dParser;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day7SolverTest {

    @Test
    void solve() throws Exception {


        var data = new ClassPathResource("testinput/day" + 7 + "test.txt");
        List<List<String>> parsed;
        try (var reader = new BufferedReader(new InputStreamReader(data.getInputStream()))) {
            parsed = Map2dParser.parseAs2dMap(reader.lines().toList(), "");
        }
        var solver = new Day7Solver();
        var res = solver.solve(parsed);
        assertEquals(21, res);
        //var res = solver.solvePartTwo(parsed);
        //assertEquals(40, res);
    }

}