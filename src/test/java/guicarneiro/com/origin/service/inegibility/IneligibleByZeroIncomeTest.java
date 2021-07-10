package guicarneiro.com.origin.service.inegibility;

import guicarneiro.com.origin.model.MaritalStatus;
import guicarneiro.com.origin.model.UserApplicationProfile;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IneligibleByZeroIncomeTest {
    @Test
    @DisplayName("When application income is 0 should return true")
    public void testIneligibleByZeroIncomeTestEqual0() {
        UserApplicationProfile user = new UserApplicationProfile(0, 0, null, 0, MaritalStatus.SINGLE, null, null);

        IneligibleByZeroIncome rule = new IneligibleByZeroIncome(user);
        assertTrue(rule.apply());
    }

    @Test
    @DisplayName("When application income is over 0 should return false")
    public void testIneligibleByZeroIncomeTestOver0() {
        UserApplicationProfile user = new UserApplicationProfile(0, 0, null, 1, MaritalStatus.SINGLE, null, null);

        IneligibleByZeroIncome rule = new IneligibleByZeroIncome(user);
        assertFalse(rule.apply());
    }


}
