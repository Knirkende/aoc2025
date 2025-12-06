package io.heimen.data.model;

import jakarta.persistence.*;

@Entity
public class FoodRange {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private long rangelow;
    private long rangehigh;

    public FoodRange(long rangelow, long rangehigh) {
        this.rangelow = rangelow;
        this.rangehigh = rangehigh;
    }
    public FoodRange() {
    }
    public Long getId() {
        return id;
    }
    public long getRangelow() {
        return rangelow;
    }
    public long getRangehigh() {
        return rangehigh;
    }
    public void setRangelow(long rangelow) {
        this.rangelow = rangelow;
    }
    public void setRangehigh(long rangehigh) {
        this.rangehigh = rangehigh;
    }
}
