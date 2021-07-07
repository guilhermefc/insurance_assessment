package guicarneiro.com.origin.service.inegibility;

import guicarneiro.com.origin.model.UserApplicationProfile;

public class IneligibleByNoVehicle extends BaseIneligibility{

    public IneligibleByNoVehicle(UserApplicationProfile user) {
        super(user);
    }

    @Override
    public boolean apply() {
        return getUser().getVehicle() == null;
    }
}
