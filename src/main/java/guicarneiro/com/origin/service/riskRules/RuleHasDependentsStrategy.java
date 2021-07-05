package guicarneiro.com.origin.service.riskRules;

import guicarneiro.com.origin.model.User;

public class RuleHasDependentsStrategy extends RuleStrategyBase {

    public RuleHasDependentsStrategy(User user, int score) {
        super(user, score);
    }

    @Override
    public int calculate() {
        if(getUser().getDependents() > 0) {
            return getScore();
        }
        return 0;
    }
}
