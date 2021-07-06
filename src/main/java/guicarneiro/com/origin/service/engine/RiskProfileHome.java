package guicarneiro.com.origin.service.engine;

import guicarneiro.com.origin.model.User;
import guicarneiro.com.origin.service.inegibility.IneligibleByNoHome;
import guicarneiro.com.origin.service.risk.HasMortgagedHouseRule;

public class RiskProfileHome extends BaseRiskProfile {

    public RiskProfileHome(User user) {
        super(user);
        riskRules.add(new HasMortgagedHouseRule(user, 1));

        ineligibilityRules.add(new IneligibleByNoHome(user));
    }

}