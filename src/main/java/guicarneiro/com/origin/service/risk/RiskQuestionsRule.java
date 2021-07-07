package guicarneiro.com.origin.service.risk;

import guicarneiro.com.origin.model.UserApplicationProfile;

import java.util.Collections;
import java.util.Optional;

public class RiskQuestionsRule extends BaseRiskRule {

    public RiskQuestionsRule(UserApplicationProfile user, int score) {
        super(user, score);
    }

    @Override
    public int apply() {
        return Optional.ofNullable(getUser().getRiskQuestions())
                .orElseGet(Collections::emptyList)
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
