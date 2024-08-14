
package edu.unisabana.pizzafactory.model;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cesarvefe
 */
public class MoldearPizzaDelgada implements Moldear {

  @Override
    public void moldearPizzaMediana() {
        System.out.println("Moldeando pizza delgada mediana");
    }

    @Override
    public void moldearPizzaPequeña() {
        System.out.println("Moldeando pizza delgada pequeña");
    }

}
