
package edu.unisabana.pizzafactory.consoleview;
import edu.unisabana.pizzafactory.model.*;
import edu.unisabana.pizzafactory.model.ExcepcionParametrosInvalidos;
import edu.unisabana.pizzafactory.model.Ingrediente;
import edu.unisabana.pizzafactory.model.Tamano;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author cesarvefe
 */
public class PreparadorPizza {

    public static void main(String[] args) {
        try {
            Ingrediente[] ingredientes = new Ingrediente[]{
                new Ingrediente("queso", 1),
                new Ingrediente("jamon", 2)
            };
            PreparadorPizza pp = new PreparadorPizza();
              Pizza pizza = seleccionarPizzaAleatoria();
            Tamano tamano = seleccionarTamanoAleatorio();
            pp.prepararPizza(pizza, ingredientes, tamano);
        } catch (ExcepcionParametrosInvalidos ex) {
            Logger.getLogger(PreparadorPizza.class.getName()).log(Level.SEVERE, "Problema en la preparación de la Pizza", ex);
        }
    }

    public void prepararPizza(Pizza pizza, Ingrediente[] ingredientes, Tamano tam) 
            throws ExcepcionParametrosInvalidos {
        Amasar am = pizza.createAmasarPizza();
        Hornear h= pizza.createHornearPizza();
        Moldear m = pizza.createMoldearPizza();

        am.amasar();

        if (tam == Tamano.PEQUENO) {
            m.moldearPizzaPequeña();
        } else if (tam == Tamano.MEDIANO) {
            m.moldearPizzaMediana();
        } else {
            throw new ExcepcionParametrosInvalidos("Tamaño de pizza inválido: " + tam);
        }

        aplicarIngredientes(ingredientes);
        h.Hornear();
    }

    private void aplicarIngredientes(Ingrediente[] ingredientes) {
        Logger.getLogger(PreparadorPizza.class.getName())
                .log(Level.INFO, "APLICANDO INGREDIENTES!: {0}", Arrays.toString(ingredientes));
        
        // CODIGO DE LLAMADO AL MICROCONTROLADOR
    }
      private static Pizza seleccionarPizzaAleatoria() {
        Random rand = new Random();
        int tipoPizza = rand.nextInt(3); // Genera un número entre 0 y 2

        switch (tipoPizza) {
            case 0:
                return new PizzaDelgada();
            case 1:
                return new PizzaGruesa();
            case 2:
                return new PizzaIntegral();
            default:
                throw new IllegalStateException("Valor inesperado para tipoPizza: " + tipoPizza);
        }
    }

    private static Tamano seleccionarTamanoAleatorio() {
        Random rand = new Random();
        int tipoTamano = rand.nextInt(Tamano.values().length); // Genera un número entre 0 y el número de elementos en Tamano

        return Tamano.values()[tipoTamano];
    }
}

