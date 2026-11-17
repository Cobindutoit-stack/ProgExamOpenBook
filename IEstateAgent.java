/**
 * Interface for estate agent calculations (Q.1.4).
 * Method names must match the exam paper exactly.
 */
public interface IEstateAgent {
    double EstateAgentSales(double[] propertySales);
    double EstateAgentCommission(double propertySales);
    int TopEstateAgent(double[] totalSales);
}
