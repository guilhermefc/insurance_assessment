package guicarneiro.com.origin.service.riskRules;

import guicarneiro.com.origin.model.User;

public class RuleAgeBetween30and40Strategy extends RuleStrategyBase {

    public RuleAgeBetween30and40Strategy(User user, int score) {
        super(user, score);
    }

    @Override
    public int calculate() {
        if(getUser().getAge() >= 30 && getUser().getAge() <= 40) {
            return getScore();
        }
        return 0;
    }
}