package guicarneiro.com.origin.model;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Arrays;

public enum MaritalStatus {
    SINGLE,
    MARRIED;

    @JsonCreator
    public static MaritalStatus setValue(String key) {
        return Arrays.stream(MaritalStatus.values())
                .filter(exampleEnum -> exampleEnum.toString().equals(key.toUpperCase()))
                .findAny()
                .orElse(null);
    }
}
