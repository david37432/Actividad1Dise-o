package com.balitechy.spacewar.main;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class BitmapBackgroundRenderer implements IBackgroundRenderer {
    private BufferedImage background;

    public BitmapBackgroundRenderer(BufferedImage background) {
        this.background = background;
    }

    @Override
    public void render(Graphics g, Canvas c) throws IOException {
        g.drawImage(background, 0, 0, c.getWidth(), c.getHeight(), c);
    }
}
