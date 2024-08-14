package com.balitechy.spacewar.main;

import java.awt.Color;
import java.awt.Graphics;

public class VectorBulletRenderer implements IBulletRenderer {
    @Override
    public void render(Graphics g, double x, double y) {
        g.setColor(Color.white);
        g.drawLine((int) x, (int) y, (int) x, (int) y - Bullet.HEIGHT);
    }
}
