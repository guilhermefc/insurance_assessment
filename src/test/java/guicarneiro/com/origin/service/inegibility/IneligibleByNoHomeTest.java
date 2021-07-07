package guicarneiro.com.origin.service.inegibility;

import guicarneiro.com.origin.model.House;
import guicarneiro.com.origin.model.MaritalStatus;
import guicarneiro.com.origin.model.OwnershipStatus;
import guicarneiro.com.origin.model.UserApplicationProfile;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IneligibleByNoHomeTest {

    @Test
    @DisplayName("When application user house is null should return true")
    public void testIneligibleByNoHomeHouseIsNull() {
        UserApplicationProfile user = new UserApplicationProfile(0, 0, null, 100, MaritalStatus.SINGLE, null, null);

        IneligibleByNoHome rule = new IneligibleByNoHome(user);
        assertTrue(rule.apply());
    }

    @Test
    @DisplayName("When application user house is Owned should return false")
    public void testIneligibleByNoHomeHouseIsOwned() {
        UserApplicationProfile user = new UserApplicationProfile(0, 0, new House(OwnershipStatus.OWNED), 100, MaritalStatus.SINGLE, null, null);

        IneligibleByNoHome rule = new IneligibleByNoHome(user);
        assertFalse(rule.apply());
    }

    @Test
    @DisplayName("When application user house is MORTGAGED should return false")
    public void testIneligibleByNoHomeHouseIsMortgaged() {
        UserApplicationProfile user = new UserApplicationProfile(0, 0, new House(OwnershipStatus.MORTGAGED), 100, MaritalStatus.SINGLE, null, null);

        IneligibleByNoHome rule = new IneligibleByNoHome(user);
        assertFalse(rule.apply());
    }
}