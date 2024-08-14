package com.balitechy.spacewar.main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Bullet {
    public static final int WIDTH =11, HEIGHT = 21;
    private int x, y;
    private int velY;
    private SpritesImageLoader spritesLoader;

    public Bullet(int x, int y, SpritesImageLoader spritesLoader) {
        this.x = x;
        this.y = y;
        this.spritesLoader = spritesLoader;
        this.velY = -5; // Velocidad hacia arriba
    }

    public void tick() {
        y += velY; // Mueve la bala hacia arriba
    }

    public void render(Graphics g) {
        BufferedImage image = spritesLoader.getImage(35, 52, WIDTH, HEIGHT); // Asegúrate de que estas coordenadas son correctas
        g.drawImage(image, x, y, null);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
