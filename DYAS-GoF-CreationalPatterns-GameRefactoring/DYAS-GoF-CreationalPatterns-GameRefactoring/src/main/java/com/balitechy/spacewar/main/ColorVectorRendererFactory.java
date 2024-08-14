package com.balitechy.spacewar.main;

import java.awt.image.BufferedImage;

public class ColorVectorRendererFactory extends RendererFactory {
    @Override
    public IPlayerRenderer createPlayerRenderer(BufferedImage image) {
        return new ColorVectorPlayerRenderer();
    }

    @Override
    public IBulletRenderer createBulletRenderer(BufferedImage image) {
        return new ColorVectorBulletRenderer();
    }

    @Override
    public IBackgroundRenderer createBackgroundRenderer(BufferedImage image) {
        return new ColorVectorBackgroundRenderer();
    }
}
