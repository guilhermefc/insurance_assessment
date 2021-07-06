package guicarneiro.com.origin.service.risk;

import guicarneiro.com.origin.model.MaritalStatus;
import guicarneiro.com.origin.model.User;

public class IsMarriedRule extends BaseRiskRule {

    public IsMarriedRule(User user, int score) {
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
