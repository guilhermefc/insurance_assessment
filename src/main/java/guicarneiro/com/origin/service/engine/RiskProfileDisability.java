package guicarneiro.com.origin.service.engine;

import guicarneiro.com.origin.model.User;
import guicarneiro.com.origin.service.inegibility.IneligibleByAgeOver60;
import guicarneiro.com.origin.service.inegibility.IneligibleByNoVehicle;
import guicarneiro.com.origin.service.inegibility.IneligibleByZeroIncome;
import guicarneiro.com.origin.service.risk.*;

public class RiskProfileDisability extends BaseRiskProfile {

    public RiskProfileDisability(User user) {
        super(user);
        riskRules.add(new HouseMortgagedStrategyRule(user, 1));
        riskRules.add(new HasDependentsStrategyRule(user, 1));
        riskRules.add(new IsMarriedStrategyRule(user, -1));

        ineligibilityRules.add(new IneligibleByZeroIncome(user));
        ineligibilityRules.add(new IneligibleByAgeOver60(user));

    }
}