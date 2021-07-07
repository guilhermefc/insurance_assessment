package guicarneiro.com.origin.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import guicarneiro.com.origin.model.*;
import org.json.JSONObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class RiskAssessmentControllerTest extends IntegrationTest {
    private static final String POST_RISK_ASSESSMENT = "/api/v1/risk-assessment";

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("When GET method submitted should return not allowed")
    void testRiskAssessmentControllerNotAllowedGet() throws Exception {
        mockMvc.perform(get(POST_RISK_ASSESSMENT)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isMethodNotAllowed());
    }

    @Test
    @DisplayName("When PUT method submitted should return not allowed")
    void testRiskAssessmentControllerNotAllowedPut() throws Exception {
        mockMvc.perform(put(POST_RISK_ASSESSMENT)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isMethodNotAllowed());
    }

    @Test
    @DisplayName("When DELETE method submitted should return not allowed")
    void testRiskAssessmentControllerNotAllowedDelete() throws Exception {
        mockMvc.perform(delete(POST_RISK_ASSESSMENT)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isMethodNotAllowed());
    }

    @Test
    @DisplayName("When PATCH method submitted should return not allowed")
    void testRiskAssessmentControllerNotAllowedPatch() throws Exception {
        mockMvc.perform(patch(POST_RISK_ASSESSMENT)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isMethodNotAllowed());
    }

    @Test
    @DisplayName("When POST method submitted with empty body should return bad request")
    void testRiskAssessmentControllerPostEmptyBody() throws Exception {
        mockMvc.perform(post(POST_RISK_ASSESSMENT)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("When risk assessment submitted with house and vehicle null should accept and provide a risk evaluation " +
            "as no house and vehicle owned ")
    void testRiskAssessmentControllerHouseAndVehicleNull() throws Exception {
        UserApplicationProfile user = new UserApplicationProfile(0, 0, null,
                100, MaritalStatus.SINGLE, List.of(0), null);

        mockMvc.perform(post(POST_RISK_ASSESSMENT)
                .content(objectMapper.writeValueAsString(user))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("When risk assessment submitted with marital status null should return bad request")
    void testRiskAssessmentControllerNullMaritalStatus() throws Exception {
        UserApplicationProfile user = new UserApplicationProfile(0, 0, null,
                100, null, List.of(0), null);

        mockMvc.perform(post(POST_RISK_ASSESSMENT)
                .content(objectMapper.writeValueAsString(user))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("When POST method submitted with correct body should return 200 OK")
    void testRiskAssessmentControllerAllowed() throws Exception {
        UserApplicationProfile user = new UserApplicationProfile(0, 0, new House(OwnershipStatus.OWNED),
                100, MaritalStatus.SINGLE, List.of(0, 1), null);

        mockMvc.perform(post(POST_RISK_ASSESSMENT)
                .content(objectMapper.writeValueAsString(user))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("When risk assessment submitted should return a correct risk evaluation")
    void testRiskAssessmentControllerRiskCorrectness() throws Exception {
        UserApplicationProfile user = new UserApplicationProfile(35, 2, new House(OwnershipStatus.OWNED),
                0, MaritalStatus.MARRIED, List.of(0, 1, 0), new Vehicle(2018));

        final String responseJson = mockMvc.perform(post(POST_RISK_ASSESSMENT)
                .content(objectMapper.writeValueAsString(user))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

            final JSONObject object = new JSONObject(responseJson);

            final String auto = object.getString("auto");
            final String disability = object.getString("disability");
            final String home = object.getString("home");
            final String life = object.getString("life");

            assertEquals("REGULAR", auto);
            assertEquals("INELIGIBLE", disability);
            assertEquals("ECONOMIC", home);
            assertEquals("REGULAR", life);
    }
}
