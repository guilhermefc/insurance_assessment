package guicarneiro.com.origin.service.inegibility;

import guicarneiro.com.origin.model.UserApplicationProfile;

public abstract class BaseIneligibility implements IneligibilityRule {
    private final UserApplicationProfile user;

    public BaseIneligibility(UserApplicationProfile user) {
        this.user = user;
    }

    public UserApplicationProfile getUser() {
        return user;
    }

}
