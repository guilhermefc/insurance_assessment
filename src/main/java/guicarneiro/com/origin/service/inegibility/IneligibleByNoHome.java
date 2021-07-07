package guicarneiro.com.origin.service.inegibility;

import guicarneiro.com.origin.model.UserApplicationProfile;

public class IneligibleByNoHome extends BaseIneligibility{

    public IneligibleByNoHome(UserApplicationProfile user) {
        super(user);
    }

    @Override
    public boolean apply() {
        return getUser().getHouse() == null;
    }
}
