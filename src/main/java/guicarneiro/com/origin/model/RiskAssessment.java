package guicarneiro.com.origin.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RiskAssessment {
    private final InsuranceStatus riskProfileAuto;
    private final InsuranceStatus riskProfileLife;
    private final InsuranceStatus riskProfileDisability;
    private final InsuranceStatus riskProfileHome;

    public RiskAssessment(
            @JsonProperty("auto") InsuranceStatus riskProfileAuto,
            @JsonProperty("disability") InsuranceStatus riskProfileDisability,
            @JsonProperty("home") InsuranceStatus riskProfileHome,
            @JsonProperty("life") InsuranceStatus riskProfileLife) {
        this.riskProfileAuto = riskProfileAuto;
        this.riskProfileLife = riskProfileLife;
        this.riskProfileDisability = riskProfileDisability;
        this.riskProfileHome = riskProfileHome;
    }

    public InsuranceStatus getRiskProfileAuto() {
        return riskProfileAuto;
    }

    public InsuranceStatus getRiskProfileLife() {
        return riskProfileLife;
    }

    public InsuranceStatus getRiskProfileDisability() {
        return riskProfileDisability;
    }

    public InsuranceStatus getRiskProfileHome() {
        return riskProfileHome;
    }
}
