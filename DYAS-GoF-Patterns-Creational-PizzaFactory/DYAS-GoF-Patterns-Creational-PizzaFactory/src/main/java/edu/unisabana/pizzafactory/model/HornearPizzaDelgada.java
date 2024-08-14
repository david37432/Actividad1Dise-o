
package edu.unisabana.pizzafactory.model;

/**
 *
 * @author cesarvefe
 */
//Aca nosotros la utilizamos para crear el objeto en PreparadosPizza 
public class HornearPizzaDelgada implements Hornear {
    @Override
    public void Hornear() {
        System.out.println("Horneando pizza delgada");
    }
}