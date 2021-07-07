package guicarneiro.com.origin.service.risk;

import guicarneiro.com.origin.model.UserApplicationProfile;
import guicarneiro.com.origin.model.Vehicle;
import guicarneiro.com.origin.utils.FakeCalendarMock;
import guicarneiro.com.origin.utils.TestUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VehicleProducedLast5YearsRuleTest {

    @Test
    @DisplayName("When user vehicle is null it should return base score")
    public void testUserVehicleNull() {
        VehicleProducedLast5YearsRule vehicleProducedLast5YearsRule = new VehicleProducedLast5YearsRule(TestUtils.userMockBasic, TestUtils.inputScore);
        assertEquals(TestUtils.baseScore, vehicleProducedLast5YearsRule.apply());
    }

    @Test
    @DisplayName("When user vehicle age is over 5 years it should return base score")
    public void testUserVehicleOver5Year() {
        new FakeCalendarMock(2021);
        UserApplicationProfile userMockVehicle2015 = new UserApplicationProfile(0, 0, null, 0, null, List.of(0, 0, 1), new Vehicle(2015));
        VehicleProducedLast5YearsRule vehicleProducedLast5YearsRule = new VehicleProducedLast5YearsRule(userMockVehicle2015, TestUtils.inputScore);
        assertEquals(TestUtils.baseScore, vehicleProducedLast5YearsRule.apply());
    }

    @Test
    @DisplayName("When user vehicle age is equal 5 years it should return input score")
    public void testUserVehicleEqual5Year() {
        new FakeCalendarMock(2021);
        UserApplicationProfile userMockVehicle2021 = new UserApplicationProfile(0, 0, null, 0, null, List.of(0, 0, 1), new Vehicle(2021));
        VehicleProducedLast5YearsRule vehicleProducedLast5YearsRule = new VehicleProducedLast5YearsRule(userMockVehicle2021, TestUtils.inputScore);
        assertEquals(TestUtils.inputScore, vehicleProducedLast5YearsRule.apply());
    }

    @Test
    @DisplayName("When user vehicle age is under 5 years it should return input score")
    public void testUserVehicleUnder5Year() {
        new FakeCalendarMock(2021);
        UserApplicationProfile userMockVehicle2020 = new UserApplicationProfile(0, 0, null, 0, null, List.of(0, 0, 1), new Vehicle(2020));
        VehicleProducedLast5YearsRule vehicleProducedLast5YearsRule = new VehicleProducedLast5YearsRule(userMockVehicle2020, TestUtils.inputScore);
        assertEquals(TestUtils.inputScore, vehicleProducedLast5YearsRule.apply());
    }
}