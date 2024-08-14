package com.balitechy.spacewar.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;

public class VectorBackgroundRenderer implements IBackgroundRenderer {
    @Override
    public void render(Graphics g, Canvas c) throws IOException {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, c.getWidth(), c.getHeight());
        g.setColor(Color.WHITE);
        g.drawOval(10, 10, 200, 200);
        //g.drawOval(c.getWidth() - 50, 0, 50, 50);
    }
}
