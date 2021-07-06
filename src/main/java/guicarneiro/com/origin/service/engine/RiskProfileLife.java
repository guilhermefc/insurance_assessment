package guicarneiro.com.origin.service.engine;

import guicarneiro.com.origin.model.User;
import guicarneiro.com.origin.service.inegibility.IneligibleByAgeOver60;
import guicarneiro.com.origin.service.inegibility.IneligibleByZeroIncome;
import guicarneiro.com.origin.service.risk.*;

public class RiskProfileLife extends BaseRiskProfile {

    public RiskProfileLife(User user) {
        super(user);
        riskRules.add(new HasDependentsStrategyRule(user, 1));
        riskRules.add(new IsMarriedStrategyRule(user, 1));

        ineligibilityRules.add(new IneligibleByAgeOver60(user));
    }

}