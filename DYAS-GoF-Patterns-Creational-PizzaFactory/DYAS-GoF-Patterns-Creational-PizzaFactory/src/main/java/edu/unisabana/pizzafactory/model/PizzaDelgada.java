/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.unisabana.pizzafactory.model;

/**
 *
 * @author David Lopez
 */
public class PizzaDelgada extends Pizza {
    @Override
    public Amasar createAmasarPizza() {
        return new AmasarPizzaDelgada();
    }

    @Override
    public Hornear createHornearPizza() {
        return new HornearPizzaDelgada();
    }

    @Override
    public Moldear createMoldearPizza() {
        return new MoldearPizzaDelgada();
    }
}