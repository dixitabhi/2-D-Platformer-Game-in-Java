/*     */ package com.game;
/*     */ 
/*     */ import com.game.entity.Entity;
/*     */ import com.game.gfx.Sprite;
/*     */ import com.game.gfx.SpriteSheet;
/*     */ import com.game.input.KeyInput;
/*     */ import java.awt.Canvas;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.image.BufferStrategy;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintStream;
/*     */ import javax.imageio.ImageIO;
/*     */ import javax.swing.JFrame;
/*     */ 
/*     */ public class Game extends Canvas
/*     */   implements Runnable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   public static final int WIDTH = 340;
/*     */   public static final int HEIGHT = 192;
/*     */   public static final int SCALE = 4;
/*     */   private Thread thread;
/*  30 */   private boolean running = false;
/*     */   public BufferedImage image;
/*     */   private static BufferedImage background;
/*     */   public static Handler handler;
/*     */   public static SpriteSheet sheet;
/*     */   public static Camera cam;
/*     */   public static Sprite grass;
/*  37 */   public static Sprite[] player = new Sprite[8];
/*     */   public static Sprite capsule;
/*     */ 
/*     */   public Game()
/*     */   {
/*  41 */     Dimension size = new Dimension(1360, 768);
/*  42 */     setPreferredSize(size);
/*  43 */     setMaximumSize(size);
/*  44 */     setMinimumSize(size);
/*     */   }
/*     */   private void init() {
/*  47 */     handler = new Handler();
/*  48 */     sheet = new SpriteSheet("/spritesheet.png");
/*  49 */     cam = new Camera();
/*  50 */     addKeyListener(new KeyInput());
/*  51 */     grass = new Sprite(sheet, 1, 1);
/*  52 */     capsule = new Sprite(sheet, 2, 1);
/*  53 */     for (int i = 0; i < player.length; i++) {
/*  54 */       player[i] = new Sprite(sheet, i + 1, 8);
/*     */     }
/*     */     try
/*     */     {
/*  58 */       this.image = ImageIO.read(getClass().getResource("/level.png"));
/*  59 */       background = ImageIO.read(getClass().getResource("/background.png"));
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/*  63 */       e.printStackTrace();
/*     */     }
/*  65 */     handler.createLevel(this.image);
/*     */   }
/*     */ 
/*     */   private synchronized void start() {
/*  69 */     if (this.running) return;
/*  70 */     this.running = true;
/*  71 */     this.thread = new Thread(this, "Thread");
/*  72 */     this.thread.start();
/*     */   }
/*     */ 
/*     */   private synchronized void stop() {
/*  76 */     if (!this.running) return;
/*  77 */     this.running = false;
/*     */     try
/*     */     {
/*  80 */       this.thread.join();
/*     */     }
/*     */     catch (InterruptedException e) {
/*  83 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void run()
/*     */   {
/*  89 */     init();
/*  90 */     requestFocus();
/*  91 */     long lastTime = System.nanoTime();
/*  92 */     long timer = System.currentTimeMillis();
/*  93 */     double delta = 0.0D;
/*  94 */     double ns = 16666666.666666666D;
/*  95 */     int frames = 0;
/*  96 */     int ticks = 0;
/*  97 */     while (this.running) {
/*  98 */       long now = System.nanoTime();
/*     */ 
/* 100 */       delta += (now - lastTime) / ns;
/* 101 */       lastTime = now;
/* 102 */       while (delta >= 1.0D) {
/* 103 */         tick();
/* 104 */         ticks++;
/* 105 */         delta -= 1.0D;
/*     */       }
/* 107 */       render();
/* 108 */       frames++;
/* 109 */       if (System.currentTimeMillis() - timer > 1000L) {
/* 110 */         timer += 1000L;
/* 111 */         System.out.println(frames + " Frames Per Second " + ticks + " Updates per Second");
/* 112 */         frames = 0;
/* 113 */         ticks = 0;
/*     */       }
/*     */     }
/* 116 */     stop();
/*     */   }
/*     */   public void render() {
/* 119 */     BufferStrategy bs = getBufferStrategy();
/* 120 */     if (bs == null) {
/* 121 */       createBufferStrategy(3);
/* 122 */       return;
/*     */     }
/* 124 */     Graphics g = bs.getDrawGraphics();
/*     */ 
/* 126 */     g.drawImage(background, 0, 0, getWidth(), getHeight(), null);
/*     */ 
/* 129 */     g.translate(cam.getX(), cam.getY());
/* 130 */     handler.render(g);
/* 131 */     g.dispose();
/* 132 */     bs.show();
/*     */   }
/*     */ 
/*     */   public void tick()
/*     */   {
/* 139 */     handler.tick();
/* 140 */     for (Entity e : handler.entity)
/* 141 */       if (e.getId() == Id.player)
/* 142 */         cam.tick(e);
/*     */   }
/*     */ 
/*     */   public int getFrameWidth()
/*     */   {
/* 148 */     return 1360;
/*     */   }
/*     */   public int getFrameHeight() {
/* 151 */     return 768;
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 156 */     Game game = new Game();
/* 157 */     JFrame frame = new JFrame("SPOOKY OUTBREAK");
/* 158 */     frame.add(game);
/* 159 */     frame.pack();
/* 160 */     frame.setResizable(false);
/* 161 */     frame.setLocationRelativeTo(null);
/* 162 */     frame.setDefaultCloseOperation(3);
/* 163 */     frame.setVisible(true);
/* 164 */     game.start();
/*     */   }
/*     */ }

/* Location:           E:\Desktop\New folder (4)\New folder\Spooky Outbreak.jar
 * Qualified Name:     com.game.Game
 * JD-Core Version:    0.6.2
 */