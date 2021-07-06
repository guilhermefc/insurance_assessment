package guicarneiro.com.origin.service.risk;

import guicarneiro.com.origin.model.User;

import java.util.Collections;
import java.util.Optional;

public class RiskQuestionsRule extends BaseRiskRule {

    public RiskQuestionsRule(User user, int score) {
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
