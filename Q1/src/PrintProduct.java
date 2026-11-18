public class PrintProduct {
    private final IProduct product;

    public PrintProduct(IProduct product) { this.product = product; }

    public void PrintReport(int year) {
        System.out.println("PRODUCT SALES REPORT - " + year);
        System.out.println("*".repeat(40));
        System.out.println("TOTAL PRODUCT SALES: " + product.GetTotalProductsSold());
        System.out.println("AVERAGE PRODUCT SALES: " + (int) product.GetAverageProductSold());
        System.out.println("MOST POPULAR PRODUCT: " + product.GetMostPopularProduct());
    }
}
