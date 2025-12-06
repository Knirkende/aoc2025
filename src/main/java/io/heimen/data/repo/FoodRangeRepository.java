package io.heimen.data.repo;

import io.heimen.data.model.FoodRange;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

//@Repository
//@Component
public interface FoodRangeRepository extends CrudRepository<FoodRange, Long> {

    @Query(value = "SELECT f FROM FoodRange f WHERE :item BETWEEN f.rangelow AND f.rangehigh")
    List<FoodRange> findRanges(@Param("item") long item);

}
