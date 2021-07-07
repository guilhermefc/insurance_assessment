package guicarneiro.com.origin.service.engine;

import guicarneiro.com.origin.model.UserApplicationProfile;
import guicarneiro.com.origin.service.inegibility.IneligibleByAgeOver60;
import guicarneiro.com.origin.service.inegibility.IneligibleByZeroIncome;
import guicarneiro.com.origin.service.risk.HasDependentsRule;
import guicarneiro.com.origin.service.risk.HasMortgagedHouseRule;
import guicarneiro.com.origin.service.risk.IsMarriedRule;

public class RiskProfileDisability extends BaseRiskProfile {

    public RiskProfileDisability(UserApplicationProfile user) {
        super(user);
        riskRules.add(new HasMortgagedHouseRule(user, 1));
        riskRules.add(new HasDependentsRule(user, 1));
        riskRules.add(new IsMarriedRule(user, -1));

        ineligibilityRules.add(new IneligibleByZeroIncome(user));
        ineligibilityRules.add(new IneligibleByAgeOver60(user));

    }
}