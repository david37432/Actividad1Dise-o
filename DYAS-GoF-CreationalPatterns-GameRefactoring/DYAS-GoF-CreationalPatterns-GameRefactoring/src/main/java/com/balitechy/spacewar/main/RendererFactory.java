package com.balitechy.spacewar.main;
import java.awt.image.BufferedImage;


public abstract class RendererFactory {
    public abstract IPlayerRenderer createPlayerRenderer(BufferedImage image);
    public abstract IBulletRenderer createBulletRenderer(BufferedImage image);
    public abstract IBackgroundRenderer createBackgroundRenderer(BufferedImage image);
    
}
