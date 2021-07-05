package guicarneiro.com.origin.service.riskAssessment;

import guicarneiro.com.origin.model.User;
import guicarneiro.com.origin.service.riskRules.*;

public class RiskProfileLife extends RiskProfileBase {

    public RiskProfileLife(User user) {
        rules.add(new RuleAgeLessThan30Strategy(user, -2));
        rules.add(new RuleAgeBetween30and40Strategy(user, -1));
        rules.add(new RuleIncomeOver200KStrategy(user, -1));

        rules.add(new RuleHasDependentsStrategy(user, 1));
        rules.add(new RuleIsMarriedStrategy(user, 1));
    }
}