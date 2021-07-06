package guicarneiro.com.origin.service.risk;

import guicarneiro.com.origin.model.MaritalStatus;
import guicarneiro.com.origin.model.User;
import guicarneiro.com.origin.utils.TestUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AgeBetween30and40RuleTest {
    @Test
    @DisplayName("When application user age is under 30 should return base score")
    public void testAgeBetween30and40RuleUnder30() {
        User user = new User(29, 0, null, 100, MaritalStatus.SINGLE, null, null);

        AgeBetween30and40Rule rule = new AgeBetween30and40Rule(user, TestUtils.inputScore);
        assertEquals(TestUtils.baseScore, rule.apply());
    }

    @Test
    @DisplayName("When application user age is equal 30 should return input score score")
    public void testAgeBetween30and40RuleEqual30() {
        User user = new User(30, 0, null, 100, MaritalStatus.SINGLE, null, null);

        AgeBetween30and40Rule rule = new AgeBetween30and40Rule(user, TestUtils.inputScore);
        assertEquals(TestUtils.inputScore, rule.apply());
    }

    @Test
    @DisplayName("When application user age is equal 40 should return input score score")
    public void testAgeBetween30and40RuleEqual40() {
        User user = new User(40, 0, null, 100, MaritalStatus.SINGLE, null, null);

        AgeBetween30and40Rule rule = new AgeBetween30and40Rule(user, TestUtils.inputScore);
        assertEquals(TestUtils.inputScore, rule.apply());
    }

    @Test
    @DisplayName("When application user age is equal 41 should return input base score")
    public void testAgeBetween30and40RuleGreaterThan40() {
        User user = new User(41, 0, null, 100, MaritalStatus.SINGLE, null, null);

        AgeBetween30and40Rule rule = new AgeBetween30and40Rule(user, TestUtils.inputScore);
        assertEquals(TestUtils.baseScore, rule.apply());
    }
}