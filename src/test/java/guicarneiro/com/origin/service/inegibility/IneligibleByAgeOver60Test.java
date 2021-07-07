package guicarneiro.com.origin.service.inegibility;

import guicarneiro.com.origin.model.MaritalStatus;
import guicarneiro.com.origin.model.UserApplicationProfile;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IneligibleByAgeOver60Test {
    @Test
    @DisplayName("When application user age is equal 60 should return false")
    public void testIneligibleByAgeOver60ValidateEqual60() {
        UserApplicationProfile user = new UserApplicationProfile(60, 0, null, 100, MaritalStatus.SINGLE, null, null);

        IneligibleByAgeOver60 rule = new IneligibleByAgeOver60(user);
        assertFalse(rule.apply());
    }

    @Test
    @DisplayName("When application user age is under 60 should return false")
    public void testIneligibleByAgeOver60ValidateUnder60() {
        UserApplicationProfile user = new UserApplicationProfile(59, 0, null, 100, MaritalStatus.SINGLE, null, null);

        IneligibleByAgeOver60 rule = new IneligibleByAgeOver60(user);
        assertFalse(rule.apply());
    }

    @Test
    @DisplayName("When application user age is greater than 60 should return true")
    public void testIneligibleByAgeOver60ValidateOver60() {
        UserApplicationProfile user = new UserApplicationProfile(61, 0, null, 100, MaritalStatus.SINGLE, null, null);

        IneligibleByAgeOver60 rule = new IneligibleByAgeOver60(user);
        assertTrue(rule.apply());
    }
}