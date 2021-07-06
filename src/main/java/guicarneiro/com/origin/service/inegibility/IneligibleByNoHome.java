package guicarneiro.com.origin.service.inegibility;

import guicarneiro.com.origin.model.User;

public class IneligibleByNoHome extends BaseIneligibility{

    public IneligibleByNoHome(User user) {
        super(user);
    }

    @Override
    public boolean apply() {
        return getUser().getHouse() == null;
    }
}
