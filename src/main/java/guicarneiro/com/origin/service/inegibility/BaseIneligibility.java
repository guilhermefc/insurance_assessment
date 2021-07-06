package guicarneiro.com.origin.service.inegibility;

import guicarneiro.com.origin.model.User;

public abstract class BaseIneligibility implements IneligibilityRule {
    private final User user;
    boolean isIneligible = false;

    public BaseIneligibility(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public boolean isIneligible() {
        return isIneligible;
    }
}
