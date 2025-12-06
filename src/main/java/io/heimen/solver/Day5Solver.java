package io.heimen.solver;

import io.heimen.data.model.FoodRange;
import io.heimen.data.repo.FoodRangeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Day5Solver {
    private static final Logger logger = LoggerFactory.getLogger(Day5Solver.class);

    private final FoodRangeRepository foodRangeRepo;

    public Day5Solver(FoodRangeRepository foodRangeRepo) {
        this.foodRangeRepo = foodRangeRepo;
    }

    public long solve(List<Long> data) {
        var res = 0L;
        for (var foodStuff : data) {
            var ranges = foodRangeRepo.findRanges(foodStuff);
            if (!ranges.isEmpty()) {
                res += 1;
            }
        }
        return res;
    }

    public long solvePartTwo() {
        var res = 0L;
        List<FoodRange> reducedRanges = new ArrayList<>();
        var allRanges = foodRangeRepo.findAllRangesSortedByRangeLow();
        reducedRanges.add(allRanges.getFirst());
        var iterator = allRanges.listIterator(1);
        while (iterator.hasNext()) {
            var current = iterator.next();
            if (current.getRangelow() <= reducedRanges.getLast().getRangehigh()) {
                var previous = reducedRanges.removeLast();
                var combinedRange = new FoodRange(previous.getRangelow(), Math.max(previous.getRangehigh(), current.getRangehigh()));
                reducedRanges.add(combinedRange);
            } else {
                reducedRanges.add(current);
            }
        }
        for (FoodRange range : reducedRanges) {
            res += range.getRangehigh() + 1 - range.getRangelow();
        }

        return res;
    }
}
