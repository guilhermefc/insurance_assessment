package guicarneiro.com.origin.service.riskRules;

import guicarneiro.com.origin.model.MaritalStatus;
import guicarneiro.com.origin.model.User;

public class RuleIsMarriedStrategy extends RuleStrategyBase {

    public RuleIsMarriedStrategy(User user, int score) {
        super(user, score);
    }

    @Override
    public int calculate() {
        if(getUser().getMaritalStatus() != null && getUser().getMaritalStatus().equals(MaritalStatus.MARRIED)) {
            return getScore();
        }
        return 0;
    }
}
