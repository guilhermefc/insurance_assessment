package guicarneiro.com.origin.service.risk;

import guicarneiro.com.origin.model.UserApplicationProfile;

public class AgeBetween30and40Rule extends BaseRiskRule {

    public AgeBetween30and40Rule(UserApplicationProfile user, int score) {
        super(user, score);
    }

    @Override
    public int apply() {
        if(getUser().getAge() >= 30 && getUser().getAge() <= 40) {
            return getScore();
        }
        return 0;
    }
}