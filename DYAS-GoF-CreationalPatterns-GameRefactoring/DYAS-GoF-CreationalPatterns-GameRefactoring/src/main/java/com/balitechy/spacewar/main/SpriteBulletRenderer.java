package com.balitechy.spacewar.main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class SpriteBulletRenderer implements IBulletRenderer {
    private BufferedImage image;

    public SpriteBulletRenderer(BufferedImage image) {
        this.image = image;
    }

    @Override
    public void render(Graphics g, double x, double y) {
        g.drawImage(image, (int) x, (int) y, null);
    }
}
