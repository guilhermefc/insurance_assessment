package guicarneiro.com.origin.service.risk;

import guicarneiro.com.origin.model.UserApplicationProfile;

import java.util.Calendar;

public class VehicleProducedLast5YearsRule extends BaseRiskRule {

    public VehicleProducedLast5YearsRule(UserApplicationProfile user, int score) {
        super(user, score);
    }

    @Override
    public int apply() {
        if(getUser().getVehicle() == null) return 0;

        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int yearDiff = currentYear - getUser().getVehicle().getYear();

        if(yearDiff <= 5) {
            return getScore();
        }
        return 0;
    }
}
