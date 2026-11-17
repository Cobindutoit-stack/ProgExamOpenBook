/**
 * Implements the estate agent calculations (Q.1.4).
 * All calculation logic lives here; Main only handles display.
 */
public class EstateAgent implements IEstateAgent {

    // Commission rate (2%) kept as a constant to avoid magic numbers
    private static final double COMMISSION_RATE = 0.02;

    /** Returns the total of one agent's monthly sales (Q.1.2). */
    @Override
    public double EstateAgentSales(double[] propertySales) {
        double total = 0;
        for (double sale : propertySales) {
            total += sale; // add each month's sale to the running total
        }
        return total;
    }

    /** Returns the 2% commission on a total sales amount (Q.1.3). */
    @Override
    public double EstateAgentCommission(double propertySales) {
        return propertySales * COMMISSION_RATE;
    }

    /** Returns the index of the agent with the highest total sales. */
    @Override
    public int TopEstateAgent(double[] totalSales) {
        int topIndex = 0;
        for (int i = 1; i < totalSales.length; i++) {
            if (totalSales[i] > totalSales[topIndex]) {
                topIndex = i; // found a higher total, remember its position
            }
        }
        return topIndex;
    }
}
