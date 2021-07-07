package guicarneiro.com.origin.service.risk;

import guicarneiro.com.origin.model.UserApplicationProfile;

public class HasDependentsRule extends BaseRiskRule {

    public HasDependentsRule(UserApplicationProfile user, int score) {
        super(user, score);
    }

    @Override
    public int apply() {
        if(getUser().getDependents() > 0) {
            return getScore();
        }
        return 0;
    }
}
