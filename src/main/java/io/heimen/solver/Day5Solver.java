package io.heimen.solver;

import io.heimen.data.repo.FoodRangeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashSet;
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
        //sort intervals by start
        //create a list of final intervals
        //for each interval, compare to previous:
        //  start less than or equal to end of previous? overlap. Start of final interval will be start of previous
        //    then: end of final interval to max of the two ends
        //    then: compare next interval to last interval in final list
        var res = 0L;
        var allRanges = foodRangeRepo.findAll();
        var goodFood = new HashSet<Long>();
        var counter = 0;
        for (var range : allRanges) {
            counter++;
            logger.info("Working on range {}", counter);
            for (long i = range.getRangelow(); i <= range.getRangehigh(); i++) {
                goodFood.add(i);
                if (goodFood.size() >= 10000) {
                    res += 10000;
                    goodFood.clear();
                }
            }
        }
        res += goodFood.size();
        return res;
    }
}
