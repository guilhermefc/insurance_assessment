package guicarneiro.com.origin.service.risk;

import guicarneiro.com.origin.model.MaritalStatus;
import guicarneiro.com.origin.model.User;

public class IsMarriedStrategyRule extends BaseRiskRule {

    public IsMarriedStrategyRule(User user, int score) {
        super(user, score);
    }

    @Override
    public int apply() {
        if(getUser().getMaritalStatus() != null && getUser().getMaritalStatus().equals(MaritalStatus.MARRIED)) {
            return getScore();
        }
        return 0;
    }
}
