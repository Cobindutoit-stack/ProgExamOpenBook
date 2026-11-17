import java.text.DecimalFormat;

/**
 * Estate agent sales report (Q.1.1 - Q.1.3).
 * Main only stores data and prints; calculations are done by EstateAgent.
 */
public class Main {

    public static void main(String[] args) {

        // Agent names - one per row of the sales array
        String[] agents = { "Joe Bloggs", "Jane Doe" };

        // Q.1.1 - 2D array: rows = agents, columns = Jan, Feb, Mar
        double[][] sales = {
            { 800000, 1500000, 2000000 }, // Joe Bloggs
            { 700000, 1200000, 1600000 }  // Jane Doe
        };

        EstateAgent estateAgent = new EstateAgent();

        // Formats numbers like 4,300,000 for totals and commission
        DecimalFormat money = new DecimalFormat("#,###");

        // ---- Header ----
        System.out.println("ESTATE AGENTS SALES REPORT\n");
        System.out.printf("%-15s%-16s%-16s%-16s%n", "", "JAN", "FEB", "MAR");
        System.out.println("-".repeat(63));

        // ---- Monthly sales table ----
        for (int i = 0; i < agents.length; i++) {
            System.out.printf("%-15s", agents[i]);
            for (int j = 0; j < sales[i].length; j++) {
                System.out.printf("%-16s", "R " + sales[i][j]);
            }
            System.out.println();
        }
        System.out.println();

        // ---- Totals (Q.1.2) ----
        double[] totals = new double[agents.length];
        for (int i = 0; i < agents.length; i++) {
            totals[i] = estateAgent.EstateAgentSales(sales[i]);
            System.out.println("Total property sales for " + agents[i]
                    + " = R " + money.format(totals[i]));
        }
        System.out.println();

        // ---- Commission (Q.1.3) ----
        for (int i = 0; i < agents.length; i++) {
            double commission = estateAgent.EstateAgentCommission(totals[i]);
            System.out.println("Sales Commission for " + agents[i]
                    + " = R " + money.format(commission));
        }
        System.out.println();

        // ---- Top agent ----
        int top = estateAgent.TopEstateAgent(totals);
        System.out.println("Top performing estate agent: " + agents[top]);
    }
}
