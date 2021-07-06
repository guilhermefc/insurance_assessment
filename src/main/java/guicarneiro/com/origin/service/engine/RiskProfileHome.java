package guicarneiro.com.origin.service.engine;

import guicarneiro.com.origin.model.User;
import guicarneiro.com.origin.service.inegibility.IneligibleByNoHome;
import guicarneiro.com.origin.service.inegibility.IneligibleByZeroIncome;
import guicarneiro.com.origin.service.risk.*;

public class RiskProfileHome extends BaseRiskProfile {

    public RiskProfileHome(User user) {
        super(user);
        riskRules.add(new HouseMortgagedStrategyRule(user, 1));

        ineligibilityRules.add(new IneligibleByNoHome(user));
    }

}