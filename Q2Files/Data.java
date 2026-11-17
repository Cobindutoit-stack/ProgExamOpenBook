package q2;

/**
 * Holds the captured form data so it can be passed to ValidateData (Q.2.7).
 * Values are kept as Strings because they come straight from the text fields.
 */
public class Data {

    private final String agentLocation;
    private final String agentName;
    private final String propertyPrice;
    private final String commissionPercentage;

    public Data(String agentLocation, String agentName,
                String propertyPrice, String commissionPercentage) {
        this.agentLocation = agentLocation;
        this.agentName = agentName;
        this.propertyPrice = propertyPrice;
        this.commissionPercentage = commissionPercentage;
    }

    public String getAgentLocation() { return agentLocation; }
    public String getAgentName() { return agentName; }
    public String getPropertyPrice() { return propertyPrice; }
    public String getCommissionPercentage() { return commissionPercentage; }
}
