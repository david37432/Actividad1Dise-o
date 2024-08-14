package com.balitechy.spacewar.main;

import java.awt.image.BufferedImage;

public class VectorRendererFactory extends RendererFactory {
    @Override
    public IPlayerRenderer createPlayerRenderer(BufferedImage image) {
        return new VectorPlayerRenderer();
    }

    @Override
    public IBulletRenderer createBulletRenderer(BufferedImage image) {
        return new VectorBulletRenderer();
    }

    @Override
    public IBackgroundRenderer createBackgroundRenderer(BufferedImage image) {
        return new VectorBackgroundRenderer();
    }
}
