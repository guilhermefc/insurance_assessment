package guicarneiro.com.origin.service.riskRules;

import guicarneiro.com.origin.model.OwnershipStatus;
import guicarneiro.com.origin.model.User;

public class RuleHouseMortagagedStrategy extends RuleStrategyBase {

    public RuleHouseMortagagedStrategy(User user, int score) {
        super(user, score);
    }

    @Override
    public int calculate() {
        if(getUser().getHouse() != null && getUser().getHouse().getOwnershipStatus().equals(OwnershipStatus.MORTGAGED)) {
            return getScore();
        }
        return 0;
    }
}
