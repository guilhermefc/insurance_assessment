package guicarneiro.com.origin.service.risk;

import guicarneiro.com.origin.model.UserApplicationProfile;
import guicarneiro.com.origin.utils.TestUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RiskQuestionsRuleTest {

    @Test
    @DisplayName("When list of question is empty should should return 0")
    public void testRiskQuestionsRuleListEmpty() {
        UserApplicationProfile user = new UserApplicationProfile(0, 0, null, 0, null, List.of(), null);
        RiskQuestionsRule rule = new RiskQuestionsRule(user, TestUtils.inputScore);
        assertEquals(TestUtils.baseScore, rule.apply());
    }

    @Test
    @DisplayName("When list of question is null should should return 0")
    public void testRiskQuestionsRuleListNull() {
        UserApplicationProfile user = new UserApplicationProfile(0, 0, null, 0, null, null, null);

        RiskQuestionsRule rule = new RiskQuestionsRule(user, TestUtils.inputScore);
        assertEquals(TestUtils.baseScore, rule.apply());
    }

    @Test
    @DisplayName("When list of question has a list of integers should return their sum")
    public void testRiskQuestionsRuleListSum() {
        UserApplicationProfile user = new UserApplicationProfile(0, 0, null, 0, null, List.of(1, 1, 4), null);

        RiskQuestionsRule rule = new RiskQuestionsRule(user, TestUtils.inputScore);
        assertEquals(6, rule.apply());
    }
}