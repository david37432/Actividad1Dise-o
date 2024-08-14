package com.balitechy.spacewar.main;

import java.awt.Color;
import java.awt.Graphics;

public class ColorVectorPlayerRenderer implements IPlayerRenderer {
    @Override
    public void render(Graphics g, double x, double y) {
     int[] xPointsExternal = {(int) x, (int) (x + Player.WIDTH), (int) x + Player.WIDTH / 2};
    int[] yPointsExternal = {(int) (y + Player.HEIGHT), (int) (y + Player.HEIGHT), (int) y};
    
    // Coordenadas del triángulo interno (escalado más pequeño)
    int margin = 10; // Margen para el triángulo interno
    int[] xPointsInternal = {
        (int) x + margin, 
        (int) (x + Player.WIDTH) - margin, 
        (int) x + Player.WIDTH / 2
    };
    int[] yPointsInternal = {
        (int) (y + Player.HEIGHT) - margin, 
        (int) (y + Player.HEIGHT) - margin, 
        (int) y + margin
    };

    // Dibujar triángulo externo
    g.setColor(Color.RED);
    g.drawPolygon(xPointsExternal, yPointsExternal, 3);

    // Dibujar triángulo interno
    g.setColor(Color.PINK);
    g.drawPolygon(xPointsInternal, yPointsInternal, 3);
    }
}