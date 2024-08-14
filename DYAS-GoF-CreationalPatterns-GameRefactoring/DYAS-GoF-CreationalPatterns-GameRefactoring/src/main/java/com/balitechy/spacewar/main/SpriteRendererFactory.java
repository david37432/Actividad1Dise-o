package com.balitechy.spacewar.main;

import java.awt.image.BufferedImage;

public class SpriteRendererFactory extends RendererFactory {
    @Override
    public IPlayerRenderer createPlayerRenderer(BufferedImage image) {
        return new SpritePlayerRenderer(image);
    }

    @Override
    public IBulletRenderer createBulletRenderer(BufferedImage image) {
        return new SpriteBulletRenderer(image);
    }

    @Override
    public IBackgroundRenderer createBackgroundRenderer(BufferedImage image) {
        return new BitmapBackgroundRenderer(image);
    }
}
