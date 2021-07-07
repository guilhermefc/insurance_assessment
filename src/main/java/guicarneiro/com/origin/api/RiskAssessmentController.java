package guicarneiro.com.origin.api;

import guicarneiro.com.origin.model.RiskAssessment;
import guicarneiro.com.origin.model.UserApplicationProfile;
import guicarneiro.com.origin.service.RiskAssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequestMapping("/api/v1/risk-assessment")
@RestController
public class RiskAssessmentController {

    private final RiskAssessmentService riskAssessmentService;

    @Autowired
    public RiskAssessmentController(RiskAssessmentService riskAssessmentService) {
        this.riskAssessmentService = riskAssessmentService;
    }

    @PostMapping
    public RiskAssessment addUser(@Valid @NonNull @RequestBody UserApplicationProfile user) {
        return riskAssessmentService.applyAssessment(user);
    }
}
