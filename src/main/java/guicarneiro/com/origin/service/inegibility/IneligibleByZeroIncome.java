package guicarneiro.com.origin.service.inegibility;

import guicarneiro.com.origin.model.UserApplicationProfile;

public class IneligibleByZeroIncome extends BaseIneligibility{
    public IneligibleByZeroIncome(UserApplicationProfile user) {
        super(user);
    }

    @Override
    public boolean apply() {
        return getUser().getIncome() == 0;
    }
}
