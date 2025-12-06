package io.heimen.solver;

import io.heimen.ElfOverseer;
import io.heimen.parser.PersistRangeParser;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class Day5SolverTest {

    @Inject
    private PersistRangeParser persistRangeParser;
    @Inject
    private Day5Solver day5Solver;
    @MockitoBean
    private ElfOverseer elfOverseer;

    @Test
    void solve() throws Exception {

        Mockito.doNothing().when(elfOverseer).run(Mockito.any(String[].class));

        var data = new ClassPathResource("testinput/day" + 5 + "test.txt");
        List<String> raw;
        try (var reader = new BufferedReader(new InputStreamReader(data.getInputStream()))) {
            raw = reader.lines().toList().stream().toList();
        }
        var parsed = persistRangeParser.parseAndPersistRanges(raw);
        var res = day5Solver.solve(parsed);
        assertEquals(3, res);
        res = day5Solver.solvePartTwo();
        assertEquals(14, res);
    }

}