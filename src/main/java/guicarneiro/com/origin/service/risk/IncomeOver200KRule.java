package guicarneiro.com.origin.service.risk;

import guicarneiro.com.origin.model.UserApplicationProfile;

public class IncomeOver200KRule extends BaseRiskRule {

    public IncomeOver200KRule(UserApplicationProfile user, int score) {
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
