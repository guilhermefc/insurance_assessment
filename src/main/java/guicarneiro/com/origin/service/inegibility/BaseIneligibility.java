package guicarneiro.com.origin.service.inegibility;

import guicarneiro.com.origin.model.User;

public abstract class BaseIneligibility implements IneligibilityRule {
    private final User user;

    public BaseIneligibility(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

}
