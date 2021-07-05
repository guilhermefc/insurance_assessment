package guicarneiro.com.origin.service.riskRules;

import guicarneiro.com.origin.model.User;

public abstract class RuleStrategyBase implements RuleStrategyInterface {
    private final User user;
    private final int score;

    public RuleStrategyBase(User user, int score) {
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
