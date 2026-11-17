package q2;

/**
 * Implements commission calculation and data validation (Q.2.7).
 * The GUI class only handles display; the logic lives here.
 */
public class EstateAgent implements IEstateAgent {

    /** Commission = property price x (percentage / 100). */
    @Override
    public double CalculateCommission(String propertyPrice, String agentCommission) {
        double price = Double.parseDouble(propertyPrice);
        double percentage = Double.parseDouble(agentCommission);
        return price * percentage / 100;
    }

    /**
     * Returns true only if all validation rules pass:
     * location and name not empty; price and percentage greater than zero.
     */
    @Override
    public boolean ValidateData(Data dataToValidate) {
        // Location and name cannot be empty
        if (dataToValidate.getAgentLocation() == null
                || dataToValidate.getAgentLocation().trim().isEmpty()) {
            return false;
        }
        if (dataToValidate.getAgentName() == null
                || dataToValidate.getAgentName().trim().isEmpty()) {
            return false;
        }

        // Price and percentage must be numbers greater than zero
        try {
            double price = Double.parseDouble(dataToValidate.getPropertyPrice());
            double percentage = Double.parseDouble(dataToValidate.getCommissionPercentage());
            return price > 0 && percentage > 0;
        } catch (NumberFormatException e) {
            return false; // not a valid number
        }
    }
}
