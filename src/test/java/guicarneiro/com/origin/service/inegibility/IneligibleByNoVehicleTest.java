package guicarneiro.com.origin.service.inegibility;

import guicarneiro.com.origin.model.MaritalStatus;
import guicarneiro.com.origin.model.User;
import guicarneiro.com.origin.model.Vehicle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IneligibleByNoVehicleTest {
    @Test
    @DisplayName("When application user vehicle is null should return true")
    public void testIneligibleByNoVehicleNull() {
        User user = new User(0, 0, null, 100, MaritalStatus.SINGLE, null, null);

        IneligibleByNoVehicle rule = new IneligibleByNoVehicle(user);
        assertTrue(rule.apply());
    }

    @Test
    @DisplayName("When application user vehicle exist should return false")
    public void testIneligibleByNoVehicleHasVehicle() {
        User user = new User(0, 0, null, 100, MaritalStatus.SINGLE, null, new Vehicle(2020));

        IneligibleByNoVehicle rule = new IneligibleByNoVehicle(user);
        assertFalse(rule.apply());
    }
}