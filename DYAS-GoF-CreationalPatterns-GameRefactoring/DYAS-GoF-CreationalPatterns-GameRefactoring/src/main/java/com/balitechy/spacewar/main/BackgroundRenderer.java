package com.balitechy.spacewar.main;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class BackgroundRenderer implements IBackgroundRenderer {
    private BufferedImage backgroundImage;

    public BackgroundRenderer(BufferedImage backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    @Override
    public void render(Graphics g, Canvas c) {
        g.drawImage(backgroundImage, 0, 0, c.getWidth(), c.getHeight(), null);
    }
}
