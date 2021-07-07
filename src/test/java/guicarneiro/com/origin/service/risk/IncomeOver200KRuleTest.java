package guicarneiro.com.origin.service.risk;

import guicarneiro.com.origin.model.MaritalStatus;
import guicarneiro.com.origin.model.UserApplicationProfile;
import guicarneiro.com.origin.utils.TestUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IncomeOver200KRuleTest {

    @Test
    @DisplayName("When application income is lower than 200k should return base score")
    public void testIncomeOver200KRuleUnder200() {
        UserApplicationProfile user = new UserApplicationProfile(0, 0, null, 100, MaritalStatus.SINGLE, null, null);

        RiskQuestionsRule rule = new RiskQuestionsRule(user, TestUtils.inputScore);
        assertEquals(TestUtils.baseScore, rule.apply());
    }

    @Test
    @DisplayName("When application income is equal 200k should return input score")
    public void testIncomeOver200KRuleEqual200() {
        UserApplicationProfile user = new UserApplicationProfile(0, 0, null, 200, MaritalStatus.MARRIED, null, null);

        IsMarriedRule rule = new IsMarriedRule(user, TestUtils.inputScore);
        assertEquals(TestUtils.inputScore, rule.apply());
    }

    @Test
    @DisplayName("When application income is higher than 200k should return input score")
    public void testIncomeOver200KRuleOver200() {
        UserApplicationProfile user = new UserApplicationProfile(0, 0, null, 201000, MaritalStatus.MARRIED, null, null);

        IsMarriedRule rule = new IsMarriedRule(user, TestUtils.inputScore);
        assertEquals(TestUtils.inputScore, rule.apply());
    }

}