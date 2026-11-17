import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for EstateAgent (Q.1.5).
 * Replace each 0 with your own numbers where marked.
 */
public class EstateAgentTest {

    private final EstateAgent agent = new EstateAgent();

    @Test
    public void CalculateTotalSales_ReturnsTotalSales() {
        double[] monthlySales = { 0, 0, 0 };   // <-- put Jan, Feb, Mar sales
        double expected = 0;                   // <-- put the total you expect

        double actual = agent.EstateAgentSales(monthlySales);

        assertEquals(expected, actual, 0.001);
    }

    @Test
    public void CalculateTotalCommission_ReturnsCommission() {
        double totalSales = 0;                 // <-- put a total sales amount
        double expected = 0;                   // <-- put the 2% commission you expect

        double actual = agent.EstateAgentCommission(totalSales);

        assertEquals(expected, actual, 0.001);
    }

    @Test
    public void TopAgent_ReturnsTopPosition() {
        double[] totals = { 0, 0 };            // <-- put agent 1 total, agent 2 total
        int expected = 0;                      // <-- put the index of the highest (0 or 1)

        int actual = agent.TopEstateAgent(totals);

        assertEquals(expected, actual);
    }
}
