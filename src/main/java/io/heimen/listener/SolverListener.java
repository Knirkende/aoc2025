package io.heimen.listener;

import io.heimen.event.parser.DataAvailableEvent;
import io.heimen.solver.Day1Solver;
import io.heimen.solver.Day2Solver;
import org.jspecify.annotations.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class SolverListener implements ApplicationListener<@NonNull DataAvailableEvent> {

    private static final Logger logger = LoggerFactory.getLogger(SolverListener.class);

    public SolverListener() {
    }

    @Override
    public void onApplicationEvent(DataAvailableEvent event) {
        switch (event.getDayNum()) {
            case 1:
                @SuppressWarnings("unchecked")
                var data = ((Map<String, List<String>>) event.getParsedData()).get("data");
                var solver = new Day1Solver();
                var res = solver.solve(data);
                logger.info("Part 1: {}", res);
                res = solver.solvePartTwo(data);
                logger.info("Part 2: {}", res);
            case 2:
                @SuppressWarnings("unchecked")
                var data2 = ((Map<String, Map<String, String>>) event.getParsedData()).get("data");
                var solver2 = new Day2Solver();
                var res2 = solver2.solve(data2);
                logger.info("Part 1: {}", res2);
                var res2_2 = solver2.solvePartTwo(data2);
                logger.info("Part 2: {}", res2_2);
        }
    }
}
