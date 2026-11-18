/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mattresssales;

/**
 *
 * @author Student
 */
import java.util.Scanner;

public class MattressSales {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] names = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};
        
        int[][] sales = new int[names.length][3];

        for (int i = 0; i < names.length; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("Enter number of sales for month " + (j + 1)
                        + " for " + names[i] + " mattress: ");
                sales[i][j] = input.nextInt();
            }
            System.out.println();
        }

        Product product = new Product(names, sales);
        
        PrintProduct printer = new PrintProduct(product);

        printer.PrintHeader();
        printer.PrintTotalProductSales();
        printer.PrintAverageProductSales();
        printer.PrintMostPopularProduct();
    }
}
