package com.balitechy.spacewar.main;

import java.awt.Graphics;
import java.util.LinkedList;

public class BulletController {
    private final LinkedList<Bullet> bl = new LinkedList<>();

    public void tick() {
        for (int i = 0; i < bl.size(); i++) {
            Bullet bullet = bl.get(i);
            bullet.tick();
            if (bullet.getY() < 0) { // Si la bala se sale de la pantalla
                removeBullet(bullet);
            }
        }
    }

    public void render(Graphics g) {
        for (Bullet bullet : bl) {
            bullet.render(g);
        }
    }

    public void addBullet(Bullet bullet) {
        bl.add(bullet);
    }

    public void removeBullet(Bullet bullet) {
        bl.remove(bullet);
    }

    public LinkedList<Bullet> getBullets() {
        return bl;
    }
}
