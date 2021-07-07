package guicarneiro.com.origin.service;

import guicarneiro.com.origin.model.RiskAssessment;
import guicarneiro.com.origin.model.UserApplicationProfile;
import guicarneiro.com.origin.service.engine.RiskProfileAuto;
import guicarneiro.com.origin.service.engine.RiskProfileDisability;
import guicarneiro.com.origin.service.engine.RiskProfileHome;
import guicarneiro.com.origin.service.engine.RiskProfileLife;
import org.springframework.stereotype.Service;


@Service
public class RiskAssessmentService {

    public RiskAssessment applyAssessment(UserApplicationProfile user) {
        return new RiskAssessment(
                new RiskProfileAuto(user).getUserProfile(),
                new RiskProfileDisability(user).getUserProfile(),
                new RiskProfileHome(user).getUserProfile(),
                new RiskProfileLife(user).getUserProfile());
    }
}
