package guicarneiro.com.origin.service.risk;

import guicarneiro.com.origin.model.User;

public class HasDependentsStrategyRule extends BaseRiskRule {

    public HasDependentsStrategyRule(User user, int score) {
        super(user, score);
    }

    @Override
    public int apply() {
        if(getUser().getDependents() > 0) {
            return getScore();
        }
        return 0;
    }
}
