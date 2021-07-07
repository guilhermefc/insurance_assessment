package guicarneiro.com.origin.service.risk;

import guicarneiro.com.origin.model.House;
import guicarneiro.com.origin.model.OwnershipStatus;
import guicarneiro.com.origin.model.UserApplicationProfile;
import guicarneiro.com.origin.model.Vehicle;
import guicarneiro.com.origin.utils.TestUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HouseMortgagedRuleTest {
    @Test
    @DisplayName("When user house is null it should return base score")
        public void testHouseRuleHouseIsNull() {
        HasMortgagedHouseRule houseMortgagedRule = new HasMortgagedHouseRule(TestUtils.userMockBasic, TestUtils.inputScore);
        assertEquals(TestUtils.baseScore, houseMortgagedRule.apply());
    }

    @Test
    @DisplayName("When user house is OWNED it should return base score")
    public void testHouseRuleHouseIsOwned() {
        UserApplicationProfile user = new UserApplicationProfile(0, 0, new House(OwnershipStatus.OWNED), 0, null, List.of(0, 0, 1), new Vehicle(2015));
        HasMortgagedHouseRule houseMortgagedRule = new HasMortgagedHouseRule(user, TestUtils.inputScore);
        assertEquals(TestUtils.baseScore, houseMortgagedRule.apply());
    }

    @Test
    @DisplayName("When user house is MORTGAGED it should return input score")
    public void testHouseRuleHouseIsMortgaged() {
        UserApplicationProfile user = new UserApplicationProfile(0, 0, new House(OwnershipStatus.MORTGAGED), 0, null, List.of(0, 0, 1), new Vehicle(2015));
        HasMortgagedHouseRule houseMortgagedRule = new HasMortgagedHouseRule(user, TestUtils.inputScore);
        assertEquals(TestUtils.inputScore, houseMortgagedRule.apply());
    }

}