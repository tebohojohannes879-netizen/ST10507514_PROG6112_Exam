/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mattresssales;

/**
 *
 * @author Student
 */
public class Product implements IProduct {

    private String[] names;
    private int[][] sales;

    public Product(String[] names, int[][] sales) {
        this.names = names;
        this.sales = sales;
    }

    @Override
    public int GetTotalProductsSold() {
        
        int total = 0;
        
        for (int i = 0; i < sales.length; i++) {
            for (int j = 0; j < sales[i].length; j++) {
                total += sales[i][j];
            }
        }
        return total;
    }

    @Override
    public double GetAverageProductSold() {
        
        int count = 0;
        
        for (int i = 0; i < sales.length; i++) {
            count += sales[i].length;
        }
        return (double) GetTotalProductsSold() / count;
    }

    @Override
    public String GetMostPopularProduct() {
        
        int bestProduct = 0;
        int bestTotal = 0;

        for (int i = 0; i < sales.length; i++) {
            int productTotal = 0;
            for (int j = 0; j < sales[i].length; j++) {
                productTotal += sales[i][j];
            }
            if (productTotal > bestTotal) {
                bestTotal = productTotal;
                bestProduct = i;
            }
        }

        int bestMonth = 0;
        
        for (int i = 0; i < sales[bestProduct].length; i++) {
            if (sales[bestProduct][i] > bestMonth) {
                bestMonth = sales[bestProduct][i];
            }
        }
        
        return names[bestProduct] + "(" + bestMonth + ")";
    }
}
