package guicarneiro.com.origin.service.risk;

import guicarneiro.com.origin.model.User;

public class AgeLessThan30Rule extends BaseRiskRule {

    public AgeLessThan30Rule(User user, int score) {
        super(user, score);
    }

    @Override
    public int apply() {
        if(super.getUser().getAge() < 30) {
            return getScore();
        }
        return 0;
    }
}
