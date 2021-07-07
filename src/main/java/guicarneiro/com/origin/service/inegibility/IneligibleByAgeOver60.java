package guicarneiro.com.origin.service.inegibility;

import guicarneiro.com.origin.model.UserApplicationProfile;

public class IneligibleByAgeOver60 extends BaseIneligibility{

    public IneligibleByAgeOver60(UserApplicationProfile user) {
        super(user);
    }

    @Override
    public boolean apply() {
        return getUser().getAge() > 60;
    }
}
