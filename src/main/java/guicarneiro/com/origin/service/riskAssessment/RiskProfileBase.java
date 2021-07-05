package guicarneiro.com.origin.service.riskAssessment;

import guicarneiro.com.origin.model.InsuranceStatus;
import guicarneiro.com.origin.service.riskRules.RuleStrategyBase;

import java.util.ArrayList;
import java.util.List;

public abstract class RiskProfileBase {

    private int score = 0;
    List<RuleStrategyBase> rules = new ArrayList<>();

    private void calculateScore() {
        for (RuleStrategyBase rule : rules) {
            score += rule.calculate();
        }
    }

    // TODO: 04/07/21 add ineligibility cases
    
    public InsuranceStatus getUserProfile() {
        calculateScore();
        System.out.println("risk score is: " + score);

        if(score <= 0) {
            return InsuranceStatus.ECONOMIC;
        } else if(score <= 2) {
            return InsuranceStatus.REGULAR;
        } else {
            return InsuranceStatus.RESPONSIBLE;
        }
    }
}
