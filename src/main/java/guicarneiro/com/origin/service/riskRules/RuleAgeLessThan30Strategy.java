package guicarneiro.com.origin.service.riskRules;

import guicarneiro.com.origin.model.User;

public class RuleAgeLessThan30Strategy extends RuleStrategyBase {

    public RuleAgeLessThan30Strategy(User user, int score) {
        super(user, score);
    }

    @Override
    public int calculate() {
        if(super.getUser().getAge() < 30) {
            return getScore();
        }
        return 0;
    }
}
