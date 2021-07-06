package guicarneiro.com.origin.service.inegibility;

import guicarneiro.com.origin.model.User;

public class IneligibleByZeroIncome extends BaseIneligibility{
    public IneligibleByZeroIncome(User user) {
        super(user);
    }

    @Override
    public boolean apply() {
        return getUser().getIncome() == 0;
    }
}
