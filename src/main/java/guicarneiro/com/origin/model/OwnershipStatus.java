package guicarneiro.com.origin.model;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Arrays;

public enum OwnershipStatus {
    OWNED,
    MORTGAGED;

    @JsonCreator
    public static OwnershipStatus setValue(String key) {
        return Arrays.stream(OwnershipStatus.values())
                .filter(exampleEnum -> exampleEnum.toString().equals(key.toUpperCase()))
                .findAny()
                .orElse(null);
    }
}