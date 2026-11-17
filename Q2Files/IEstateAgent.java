package q2;

/**
 * Interface for estate agent commission and validation (Q.2.7).
 * Method names must match the exam paper exactly.
 */
public interface IEstateAgent {
    double CalculateCommission(String propertyPrice, String agentCommission);
    boolean ValidateData(Data dataToValidate);
}
