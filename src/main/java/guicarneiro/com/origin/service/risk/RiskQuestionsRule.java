package guicarneiro.com.origin.service.risk;

import guicarneiro.com.origin.model.User;

public class RiskQuestionsRule extends BaseRiskRule {

    public RiskQuestionsRule(User user, int score) {
        super(user, score);
    }

    @Override
    public int apply() {
        return getUser().getRiskQuestions()
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
