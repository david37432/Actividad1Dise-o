
package com.balitechy.spacewar.main;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class SpritesImageLoader {
    private BufferedImage spritesheet;

    public SpritesImageLoader(String path) {
        try {
            spritesheet = ImageIO.read(getClass().getResource(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadImage() throws IOException {
        // En este caso, la imagen ya se carga en el constructor, así que puedes dejar este método vacío o eliminarlo
    }

    public BufferedImage getImage(int x, int y, int width, int height) {
        return spritesheet.getSubimage(x, y, width, height);
    }
}
