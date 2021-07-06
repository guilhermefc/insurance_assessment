package guicarneiro.com.origin.service.risk;

import guicarneiro.com.origin.model.OwnershipStatus;
import guicarneiro.com.origin.model.User;

public class HouseMortgagedStrategyRule extends BaseRiskRule {

    public HouseMortgagedStrategyRule(User user, int score) {
        super(user, score);
    }

    @Override
    public int apply() {
        if(getUser().getHouse() != null && getUser().getHouse().getOwnershipStatus().equals(OwnershipStatus.MORTGAGED)) {
            return getScore();
        }
        return 0;
    }
}
