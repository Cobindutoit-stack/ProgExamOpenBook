import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductTest {
    private final Product p = new Product(
        new String[]{"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"},
        new int[][]{{25, 18, 20}, {15, 10, 12}, {18, 15, 20}});

    @Test
    void GetTotalProductSales_WithValidData_ReturnsCorrectValue() {
        assertEquals(153, p.GetTotalProductsSold());
    }

    @Test
    void GetAverageSales_WithValidData_ReturnsCorrectValue() {
        assertEquals(17.0, p.GetAverageProductSold(), 0.001);
    }
}
