package com.balitechy.spacewar.main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class SpritePlayerRenderer implements IPlayerRenderer {
    private final BufferedImage image;

    public SpritePlayerRenderer(BufferedImage image) {
        this.image = image;
    }

    @Override
    public void render(Graphics g, double x, double y) {
        g.drawImage(image, (int) x, (int) y, null);
    }
}
