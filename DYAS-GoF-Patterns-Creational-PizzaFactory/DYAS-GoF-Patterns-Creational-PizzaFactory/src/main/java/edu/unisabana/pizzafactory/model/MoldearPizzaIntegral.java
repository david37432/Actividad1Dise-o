/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.unisabana.pizzafactory.model;

/**
 *
 * @author David Lopez
 */
public class MoldearPizzaIntegral implements Moldear {
    @Override
    public void moldearPizzaMediana() {
        System.out.println("Moldeando pizza integral mediana");
    }

    @Override
    public void moldearPizzaPequeña() {
        System.out.println("Moldeando pizza integral pequeña");
    }
}

