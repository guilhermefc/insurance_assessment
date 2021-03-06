package guicarneiro.com.origin.service.engine;

import guicarneiro.com.origin.model.UserApplicationProfile;
import guicarneiro.com.origin.service.inegibility.IneligibleByNoVehicle;
import guicarneiro.com.origin.service.risk.VehicleProducedLast5YearsRule;

public class RiskProfileAuto extends BaseRiskProfile {

    public RiskProfileAuto(UserApplicationProfile user) {
        super(user);
        riskRules.add(new VehicleProducedLast5YearsRule(user, 1));

        ineligibilityRules.add(new IneligibleByNoVehicle(user));
    }

}
