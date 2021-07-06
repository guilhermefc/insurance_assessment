package guicarneiro.com.origin.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import javax.validation.constraints.*;
import java.util.List;
import java.util.UUID;

public class User {

    private final UUID id;

    @Min(0)
    private final Integer age;
    @Min(0)
    private final Integer dependents;
    @Min(0)
    private final Integer income;
    @NotNull
    private final MaritalStatus maritalStatus;
    @NotEmpty
    private final List<@Min(0) @Max(1) Integer> riskQuestions;
    private final House house;
    private final Vehicle vehicle;

    // TODO: 04/07/21 write tests for validate inputs
    // TODO: 04/07/21 review this uuid initialization
    public User(@JsonProperty("age") int age,
                @JsonProperty("dependents") int dependents,
                @JsonProperty("house") House house,
                @JsonProperty("income") int income,
                @JsonProperty("marital_status") MaritalStatus maritalStatus,
                @JsonProperty("risk_questions") List<Integer> riskQuestions,
                @JsonProperty("vehicle") Vehicle vehicle) {
        this.id = UUID.randomUUID();
        this.age = age;
        this.dependents = dependents;
        this.house = house;
        this.income = income;
        this.maritalStatus = maritalStatus;
        this.riskQuestions = riskQuestions;
        this.vehicle = vehicle;
    }

    public UUID getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public int getDependents() {
        return dependents;
    }

    public House getHouse() {
        return house;
    }

    public int getIncome() {
        return income;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public List<Integer> getRiskQuestions() {
        return riskQuestions;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}
