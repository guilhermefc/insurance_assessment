package guicarneiro.com.origin.service.riskRules;

import guicarneiro.com.origin.model.User;

public class RuleIncomeOver200KStrategy extends RuleStrategyBase {

    public RuleIncomeOver200KStrategy(User user, int score) {
        super(user, score);
    }

    @Override
    public int calculate() {
        if(super.getUser().getIncome() > 200) {
            return getScore();
        }
        return 0;
    }
}
