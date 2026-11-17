package q2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for EstateAgent (Q.2.8).
 * Everything else in Q2 is complete. Only the 10 lines marked
 * "INSERT HERE" below need your own values.
 */
public class EstateAgentTest {

    private final EstateAgent agent = new EstateAgent();

    @Test
    public void CalculateCommission_CalculatedSuccessfully() {
        // INSERT HERE (1): a property price in quotes, e.g. "800000"
        String propertyPrice = "0";
        // INSERT HERE (2): a commission percentage in quotes, e.g. "10"
        String commissionPercentage = "0";
        // INSERT HERE (3): the commission YOU calculate by hand (a plain number)
        double expected = 0;

        double actual = agent.CalculateCommission(propertyPrice, commissionPercentage);

        assertEquals(expected, actual, 0.001);
    }

    @Test
    public void CalculateCommission_CalculatedUnSuccessfully() {
        // INSERT HERE (4): a property price in quotes
        String propertyPrice = "0";
        // INSERT HERE (5): a commission percentage in quotes
        String commissionPercentage = "0";
        // INSERT HERE (6): a number that is NOT the correct commission for the values above
        double wrongValue = 0;

        double actual = agent.CalculateCommission(propertyPrice, commissionPercentage);

        // Proves the calculation does not produce the wrong value
        assertNotEquals(wrongValue, actual, 0.001);
    }

    @Test
    public void ValidateData_ValidDataReturnsTrue() {
        // INSERT HERE (7): a location in quotes, e.g. "Cape Town"
        String location = "location";
        // INSERT HERE (8): an agent name in quotes, e.g. "Joe Bloggs"
        String name = "name";
        // INSERT HERE (9): a price greater than zero, in quotes
        String price = "0";
        // INSERT HERE (10): a percentage greater than zero, in quotes
        String percentage = "0";

        Data data = new Data(location, name, price, percentage);

        assertTrue(agent.ValidateData(data));
    }
}
