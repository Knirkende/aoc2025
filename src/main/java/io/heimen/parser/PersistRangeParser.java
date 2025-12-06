package io.heimen.parser;


import io.heimen.data.model.FoodRange;
import io.heimen.data.repo.FoodRangeRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class PersistRangeParser {

    private final FoodRangeRepository foodRangeRepo;

    public PersistRangeParser(FoodRangeRepository foodRangeRepo) {
        this.foodRangeRepo = foodRangeRepo;
    }

    public List<Long> parseAndPersistRanges(List<String> rawData) {
        var food = new ArrayList<Long>();
        for (var rawLine : rawData) {
            if (rawLine.isBlank()) continue;
            var range = rawLine.split("-");
            if (range.length != 2) {
                food.add(Long.parseLong(range[0]));
            } else {
                var sortedRange = Arrays.stream(range).map(Long::parseLong).sorted().toList();
                var foodRange = new FoodRange(sortedRange.get(0), sortedRange.get(1));
                foodRangeRepo.save(foodRange);
            }
        }
        return food;
    }

}
