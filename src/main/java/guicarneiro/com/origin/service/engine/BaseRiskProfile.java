package guicarneiro.com.origin.service.engine;

import guicarneiro.com.origin.model.InsuranceStatus;
import guicarneiro.com.origin.model.User;
import guicarneiro.com.origin.service.inegibility.BaseIneligibility;
import guicarneiro.com.origin.service.inegibility.IneligibilityRule;
import guicarneiro.com.origin.service.risk.*;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseRiskProfile {

    final User user;
    final List<BaseRiskRule> riskRules = new ArrayList<>();
    final List<BaseIneligibility> ineligibilityRules = new ArrayList<>();

    public BaseRiskProfile(User user) {
        this.user = user;
        addDefaultRiskRules();
    }

    private void addDefaultRiskRules() {
        // TODO: 06/07/21 add this score numbers as project properties
        riskRules.add(new RiskQuestionsRule(user, 0));
        riskRules.add(new AgeLessThan30Rule(user, -2));
        riskRules.add(new AgeBetween30and40Rule(user, -1));
        riskRules.add(new IncomeOver200KRule(user, -1));
    }

    private int calculateScore() {
        return riskRules.stream()
                .map(RiskRule::apply)
                .mapToInt(Integer::intValue)
                .sum();
    }

    private boolean validateIneligibility() {
        return ineligibilityRules.stream()
                .anyMatch(IneligibilityRule::apply);
    }

    public InsuranceStatus getUserProfile() {
        if(validateIneligibility()) {
            return InsuranceStatus.INELIGIBLE;
        }

        int score = calculateScore();
        if(score <= 0) {
            return InsuranceStatus.ECONOMIC;
        } else if(score <= 2) {
            return InsuranceStatus.REGULAR;
        } else {
            return InsuranceStatus.RESPONSIBLE;
        }
    }
}
