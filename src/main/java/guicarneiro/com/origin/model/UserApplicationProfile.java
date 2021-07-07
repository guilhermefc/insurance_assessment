package guicarneiro.com.origin.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class UserApplicationProfile {

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

    public UserApplicationProfile(@JsonProperty("age") int age,
                                  @JsonProperty("dependents") int dependents,
                                  @JsonProperty("house") House house,
                                  @JsonProperty("income") int income,
                                  @JsonProperty("marital_status") MaritalStatus maritalStatus,
                                  @JsonProperty("risk_questions") List<Integer> riskQuestions,
                                  @JsonProperty("vehicle") Vehicle vehicle) {
        this.age = age;
        this.dependents = dependents;
        this.house = house;
        this.income = income;
        this.maritalStatus = maritalStatus;
        this.riskQuestions = riskQuestions;
        this.vehicle = vehicle;
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
