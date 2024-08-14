
package com.balitechy.spacewar.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Player {
    private double x, y;
    private double velX, velY; // Velocidad en ambas direcciones
    public static final int WIDTH = 56;
    public static final int HEIGHT = 28;

    private BufferedImage image;
    private Game game;

    public Player(int x, int y, Game game) {
        this.x = x;
        this.y = y;
        this.game = game;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setVelX(double velX) {
        this.velX = velX;
    }

    public void setVelY(double velY) {
        this.velY = velY; // Actualiza la velocidad vertical
    }

    public void shoot() {
        Bullet bullet = new Bullet((int) (x + (WIDTH / 2)), (int) y, game.getSprites());
        game.getBullets().addBullet(bullet);
    }

    public void tick() {
        x += velX;
        y += velY; // Mueve al jugador en la dirección vertical

        // Lógica para limitar el movimiento
        if (x < 0) x = 0;
        if (x > Game.WIDTH * Game.SCALE - WIDTH) x = Game.WIDTH * Game.SCALE - WIDTH;
        if (y < 0) y = 0; // Asegúrate de que no se mueva fuera de la pantalla
        if (y > Game.HEIGHT * Game.SCALE - HEIGHT) y = Game.HEIGHT * Game.SCALE - HEIGHT; // Limita el movimiento hacia abajo
    }
}
