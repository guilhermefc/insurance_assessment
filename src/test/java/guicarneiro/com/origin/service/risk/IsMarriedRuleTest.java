package guicarneiro.com.origin.service.risk;

import guicarneiro.com.origin.model.MaritalStatus;
import guicarneiro.com.origin.model.UserApplicationProfile;
import guicarneiro.com.origin.utils.TestUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IsMarriedRuleTest {

    @Test
    @DisplayName("When user has no maritalStatus should return base score")
    public void testIsMarriedRuleTestNull() {
        UserApplicationProfile user = new UserApplicationProfile(0, 0, null, 0, null, List.of(), null);
        RiskQuestionsRule rule = new RiskQuestionsRule(user, TestUtils.inputScore);
        assertEquals(TestUtils.baseScore, rule.apply());
    }

    @Test
    @DisplayName("When user has maritalStatus as single should return base score")
    public void testIsMarriedRuleTestSingle() {
        UserApplicationProfile user = new UserApplicationProfile(0, 0, null, 0, MaritalStatus.SINGLE, null, null);

        RiskQuestionsRule rule = new RiskQuestionsRule(user, TestUtils.inputScore);
        assertEquals(TestUtils.baseScore, rule.apply());
    }

    @Test
    @DisplayName("When user has maritalStatus as married should return input score")
    public void testIsMarriedRuleTestMarried() {
        UserApplicationProfile user = new UserApplicationProfile(0, 0, null, 0, MaritalStatus.MARRIED, null, null);

        IsMarriedRule rule = new IsMarriedRule(user, TestUtils.inputScore);
        assertEquals(TestUtils.inputScore, rule.apply());
    }

}
