package guicarneiro.com.origin.service.risk;

import guicarneiro.com.origin.model.UserApplicationProfile;

public abstract class BaseRiskRule implements RiskRule {
    private final UserApplicationProfile user;
    private final int score;

    public BaseRiskRule(UserApplicationProfile user, int score) {
        this.user = user;
        this.score = score;
    }

    public UserApplicationProfile getUser() {
        return user;
    }

    public int getScore() {
        return score;
    }
}
