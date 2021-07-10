package guicarneiro.com.origin.service.engine;

import guicarneiro.com.origin.model.UserApplicationProfile;
import guicarneiro.com.origin.service.inegibility.IneligibleByAgeOver60;
import guicarneiro.com.origin.service.risk.HasDependentsRule;
import guicarneiro.com.origin.service.risk.IsMarriedRule;

public class RiskProfileLife extends BaseRiskProfile {

    public RiskProfileLife(UserApplicationProfile user) {
        super(user);
        riskRules.add(new HasDependentsRule(user, 1));
        riskRules.add(new IsMarriedRule(user, 1));

        ineligibilityRules.add(new IneligibleByAgeOver60(user));
    }

}
