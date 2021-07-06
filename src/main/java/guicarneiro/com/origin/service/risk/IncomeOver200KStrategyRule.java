package guicarneiro.com.origin.service.risk;

import guicarneiro.com.origin.model.User;

public class IncomeOver200KStrategyRule extends BaseRiskRule {

    public IncomeOver200KStrategyRule(User user, int score) {
        super(user, score);
    }

    @Override
    public int apply() {
        if(super.getUser().getIncome() > 200) {
            return getScore();
        }
        return 0;
    }
}
