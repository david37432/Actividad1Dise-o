package com.balitechy.spacewar.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable {

    private static final long serialVersionUID = 1L;
    public static final int WIDTH = 320;
    public static final int HEIGHT = WIDTH / 12 * 9;
    public static final int SCALE = 2;
    public final String TITLE = "Space War 2D";

    private boolean running = false;
    private Thread thread;
    private SpritesImageLoader sprites;
    private SpritesImageLoader sprites2;

    // Game components
    private Player player;
    private BulletController bullets;
    private IBackgroundRenderer backgroundRenderer;
    private IPlayerRenderer playerRenderer;
    private IBulletRenderer bulletRenderer;
    private RendererFactory rendererFactory;

    public void init() {
        requestFocus();

        // Carga la imagen de sprites
        sprites = new SpritesImageLoader("/sprites.png");
        sprites2 = new SpritesImageLoader("/bg.png");
        try {
            sprites.loadImage(); // Asegúrate de que esta función esté definida en SpritesImageLoader
        } catch (IOException e) {
        }

        // Agrega el manejador de entrada
        addKeyListener(new InputHandler(this));

        // Inicializa los componentes del juego
        player = new Player((WIDTH * SCALE - Player.WIDTH) / 2, HEIGHT * SCALE - 50, this);
        bullets = new BulletController();

        // Establece el estilo de renderizado
        setRenderStyle("1"); // 1(sprites), 2(Vectorial) 3(ColorVector)
    }

   public void setRenderStyle(String style) {
    BufferedImage playerImage = sprites.getImage(219, 304, Player.WIDTH, Player.HEIGHT);
    BufferedImage bulletImage = sprites.getImage(35, 52, Bullet.WIDTH, Bullet.HEIGHT);
    if (style.equals("1")) {
        rendererFactory = new SpriteRendererFactory();//imagen
        playerRenderer = rendererFactory.createPlayerRenderer(playerImage);
        bulletRenderer = rendererFactory.createBulletRenderer(bulletImage);
        backgroundRenderer = rendererFactory.createBackgroundRenderer(sprites2.getImage(0, 0, WIDTH, HEIGHT));
    } else if (style.equals("2")) {
        rendererFactory = new VectorRendererFactory();
        playerRenderer = rendererFactory.createPlayerRenderer(null);
        bulletRenderer = rendererFactory.createBulletRenderer(null);
        backgroundRenderer = rendererFactory.createBackgroundRenderer(null);
    }
     else if (style.equals("3")) {
        rendererFactory = new ColorVectorRendererFactory();
        playerRenderer = rendererFactory.createPlayerRenderer(null);
        bulletRenderer = rendererFactory.createBulletRenderer(null);
        backgroundRenderer = rendererFactory.createBackgroundRenderer(null);
    }
}


    public SpritesImageLoader getSprites() {
        return sprites;
    }

    public BulletController getBullets() {
        return bullets;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        switch (key) {
            case KeyEvent.VK_RIGHT:
                player.setVelX(5);
                break;

            case KeyEvent.VK_LEFT:
                player.setVelX(-5);
                break;

            case KeyEvent.VK_UP:
                player.setVelY(-5); // Aumenta la velocidad hacia arriba
                break;

            case KeyEvent.VK_DOWN:
                player.setVelY(5); // Aumenta la velocidad hacia abajo
                break;

            case KeyEvent.VK_SPACE:
                player.shoot();
                break;
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        switch (key) {
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_LEFT:
                player.setVelX(0);
                break;

            case KeyEvent.VK_UP:
            case KeyEvent.VK_DOWN:
                player.setVelY(0); // Detiene el movimiento vertical
                break;
        }
    }

    private synchronized void start() {
        if (running) return;

        running = true;
        thread = new Thread(this);
        thread.start();
    }

    private synchronized void stop() {
        if (!running) return;

        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.exit(1);
    }

    @Override
    public void run() {
        init();

        long lastTime = System.nanoTime();
        final double numOfTicks = 60.0;
        double ns = 1000000000 / numOfTicks;
        double delta = 0;
        int updates = 0;
        int frames = 0;
        long timer = System.currentTimeMillis();

        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            if (delta >= 1) {
                tick();
                updates++;
                delta--;
            }
            render();
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println(updates + " ticks, fps " + frames);
                updates = 0;
                frames = 0;
            }
        }
        stop();
    }

    public void tick() {
        player.tick();
        bullets.tick();
    }

    public void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        // Limpia el fondo con un color
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());

        try {
            backgroundRenderer.render(g, this);
            playerRenderer.render(g, player.getX(), player.getY());
            for (Bullet bullet : bullets.getBullets()) {
                bulletRenderer.render(g, bullet.getX(), bullet.getY());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        g.dispose();
        bs.show();
    }

    public static void main(String args[]) {
        Game game = new Game();
        game.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        game.setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        game.setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));

        JFrame frame = new JFrame(game.TITLE);
        frame.add(game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        game.start();
    }
}
