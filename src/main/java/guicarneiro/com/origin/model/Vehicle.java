package guicarneiro.com.origin.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Vehicle {
    private final int year;

    public Vehicle(@JsonProperty("year") int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }
}
