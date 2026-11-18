/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mattresssales;

/**
 *
 * @author Student
 */
public class PrintProduct {

    private IProduct product;

    public PrintProduct(IProduct product) {
        this.product = product;
    }

    public void PrintHeader() {
        System.out.println("\nPRODUCT SALES REPORT-2026");
        System.out.println();
        System.out.println("************************************************");
    }

    public void PrintTotalProductSales() {
        System.out.println("TOTAL PRODUCT SALES: " + product.GetTotalProductsSold());
    }

    public void PrintAverageProductSales() {
        System.out.printf("AVERAGE PRODUCT SALES: %.0f%n", product.GetAverageProductSold());
    }

    public void PrintMostPopularProduct() {
        System.out.println("MOST POPULAR PRODUCT: " + product.GetMostPopularProduct());
    }
}
