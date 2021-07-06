package guicarneiro.com.origin.service.inegibility;

import guicarneiro.com.origin.model.User;

public class IneligibleByNoVehicle extends BaseIneligibility{

    public IneligibleByNoVehicle(User user) {
        super(user);
    }

    @Override
    public boolean apply() {
        return getUser().getVehicle() == null;
    }
}
