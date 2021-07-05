package guicarneiro.com.origin.service.riskAssessment;

import guicarneiro.com.origin.model.User;
import guicarneiro.com.origin.service.riskRules.*;

public class RiskProfileAuto extends RiskProfileBase {

    public RiskProfileAuto(User user) {
        rules.add(new RuleAgeLessThan30Strategy(user, -2));
        rules.add(new RuleAgeBetween30and40Strategy(user, -1));
        rules.add(new RuleIncomeOver200KStrategy(user, -1));
        rules.add(new RuleVehicleProducedLast5YearsStrategy(user, 1));
    }
}
