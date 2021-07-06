package guicarneiro.com.origin.service;

import guicarneiro.com.origin.model.RiskAssessment;
import guicarneiro.com.origin.model.User;
import guicarneiro.com.origin.service.engine.*;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    public RiskAssessment addUser(User user) {
        return new RiskAssessment(
                new RiskProfileAuto(user).getUserProfile(),
                new RiskProfileDisability(user).getUserProfile(),
                new RiskProfileHome(user).getUserProfile(),
                new RiskProfileLife(user).getUserProfile());
    }
}
