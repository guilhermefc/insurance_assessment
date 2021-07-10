package guicarneiro.com.origin.service.risk;

import guicarneiro.com.origin.model.MaritalStatus;
import guicarneiro.com.origin.model.UserApplicationProfile;
import guicarneiro.com.origin.utils.TestUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HasDependentsRuleTest {

    @Test
    @DisplayName("When application has 0 dependents should return base score")
    public void testHasDependentsRule0() {
        UserApplicationProfile user = new UserApplicationProfile(0, 0, null, 100, MaritalStatus.SINGLE, null, null);

        HasDependentsRule rule = new HasDependentsRule(user, TestUtils.inputScore);
        assertEquals(TestUtils.baseScore, rule.apply());
    }

    @Test
    @DisplayName("When application has 1 dependents should return input score")
    public void testHasDependentsRule1() {
        UserApplicationProfile user = new UserApplicationProfile(0, 1, null, 200, MaritalStatus.MARRIED, null, null);

        HasDependentsRule rule = new HasDependentsRule(user, TestUtils.inputScore);
        assertEquals(TestUtils.inputScore, rule.apply());
    }

}
