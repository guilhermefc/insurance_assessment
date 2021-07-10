package guicarneiro.com.origin.service.engine;

import guicarneiro.com.origin.model.UserApplicationProfile;
import guicarneiro.com.origin.service.inegibility.IneligibleByNoHome;
import guicarneiro.com.origin.service.risk.HasMortgagedHouseRule;

public class RiskProfileHome extends BaseRiskProfile {

    public RiskProfileHome(UserApplicationProfile user) {
        super(user);
        riskRules.add(new HasMortgagedHouseRule(user, 1));

        ineligibilityRules.add(new IneligibleByNoHome(user));
    }

}
