package guicarneiro.com.origin.service.risk;

import guicarneiro.com.origin.model.User;

public abstract class BaseRiskRule implements RiskRule {
    private final User user;
    private final int score;

    public BaseRiskRule(User user, int score) {
        this.user = user;
        this.score = score;
    }

    public User getUser() {
        return user;
    }

    public int getScore() {
        return score;
    }
}
