/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package test.newpackage;
/**
 *
 * @author Student
 */
import com.mycompany.mattresssales.Product;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductTest {

    private Product createProduct() {
        String[] names = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};
        int[][] sales = {
            {25, 18, 20},
            {15, 10, 12},
            {18, 15, 20}
        };
        return new Product(names, sales);
    }

    @Test
    public void GetTotalProductSales_WithValidData_ReturnsCorrectValue() {
        Product product = createProduct();
        assertEquals(153, product.GetTotalProductsSold());
    }

    @Test
    public void GetAverageSales_WithValidData_ReturnsCorrectValue() {
        Product product = createProduct();
        assertEquals(17.0, product.GetAverageProductSold(), 0.001);
    }
}