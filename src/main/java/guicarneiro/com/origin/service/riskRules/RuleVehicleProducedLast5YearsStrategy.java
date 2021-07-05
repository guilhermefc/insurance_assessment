package guicarneiro.com.origin.service.riskRules;

import guicarneiro.com.origin.model.User;

import java.util.Calendar;

public class RuleVehicleProducedLast5YearsStrategy extends RuleStrategyBase {

    public RuleVehicleProducedLast5YearsStrategy(User user, int score) {
        super(user, score);
    }

    @Override
    public int calculate() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int yearDiff = currentYear - getUser().getVehicle().getYear();

        if(yearDiff <= 5) {
            return getScore();
        }
        return 0;
    }
}
