/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.productapp;

/**
 *
 * @author Student
 */
public class ProductCalculations implements IProductCalculations {

    private final double price;

    public ProductCalculations(double price) {
        this.price = price;
    }

    @Override
    public double GetVat() {
        return price * 15 / 100;
    }

    @Override
    public double GetCommission() {
        return price * 5 / 100;
    }

    @Override
    public double GetTotal() {
        return price + GetVat() + GetCommission();
    }
}
