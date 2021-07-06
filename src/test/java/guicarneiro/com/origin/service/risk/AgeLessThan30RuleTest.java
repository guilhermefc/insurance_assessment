package guicarneiro.com.origin.service.risk;

import guicarneiro.com.origin.model.MaritalStatus;
import guicarneiro.com.origin.model.User;
import guicarneiro.com.origin.utils.TestUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AgeLessThan30RuleTest {
    @Test
    @DisplayName("When application user age is under 30 should return input score")
    public void testAgeLessThan30RuleTestUnder30() {
        User user = new User(29, 0, null, 100, MaritalStatus.SINGLE, null, null);

        AgeLessThan30Rule rule = new AgeLessThan30Rule(user, TestUtils.inputScore);
        assertEquals(TestUtils.inputScore, rule.apply());
    }

    @Test
    @DisplayName("When application user age is under 30 should return base score")
    public void testAgeLessThan30RuleTestEqual30() {
        User user = new User(30, 0, null, 100, MaritalStatus.SINGLE, null, null);

        AgeLessThan30Rule rule = new AgeLessThan30Rule(user, TestUtils.inputScore);
        assertEquals(TestUtils.baseScore, rule.apply());
    }

    @Test
    @DisplayName("When application user age is over 30 should return base score")
    public void testAgeLessThan30RuleTestOver30() {
        User user = new User(31, 0, null, 100, MaritalStatus.SINGLE, null, null);

        AgeLessThan30Rule rule = new AgeLessThan30Rule(user, TestUtils.inputScore);
        assertEquals(TestUtils.baseScore, rule.apply());
    }
}