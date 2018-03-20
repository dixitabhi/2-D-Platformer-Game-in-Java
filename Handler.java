/*    */ package com.game;
/*    */ 
/*    */ import com.game.entity.Entity;
/*    */ import com.game.entity.Player;
/*    */ import com.game.entity.powerup.Capsule;
/*    */ import com.game.tile.Tile;
/*    */ import com.game.tile.Wall;
/*    */ import java.awt.Graphics;
/*    */ import java.awt.image.BufferedImage;
/*    */ import java.util.LinkedList;
/*    */ 
/*    */ public class Handler
/*    */ {
/* 14 */   public LinkedList<Entity> entity = new LinkedList();
/* 15 */   public LinkedList<Tile> tile = new LinkedList();
/*    */ 
/*    */   public void render(Graphics g)
/*    */   {
/* 21 */     for (Entity en : this.entity) {
/* 22 */       en.render(g);
/*    */     }
/* 24 */     for (Tile ti : this.tile)
/* 25 */       ti.render(g);
/*    */   }
/*    */ 
/*    */   public void tick()
/*    */   {
/* 30 */     for (Entity en : this.entity) {
/* 31 */       en.tick();
/*    */     }
/* 33 */     for (Tile ti : this.tile)
/* 34 */       ti.tick();
/*    */   }
/*    */ 
/*    */   public void addEntity(Entity en)
/*    */   {
/* 39 */     this.entity.add(en);
/*    */   }
/*    */   public void removeEntity(Entity en) {
/* 42 */     this.entity.remove(en);
/*    */   }
/*    */   public void addTile(Tile ti) {
/* 45 */     this.tile.add(ti);
/*    */   }
/*    */   public void removeTile(Tile ti) {
/* 48 */     this.tile.remove(ti);
/*    */   }
/*    */   public void createLevel(BufferedImage level) {
/* 51 */     int width = level.getWidth();
/* 52 */     int height = level.getHeight();
/* 53 */     for (int y = 0; y < height; y++)
/* 54 */       for (int x = 0; x < width; x++) {
/* 55 */         int pixel = level.getRGB(x, y);
/* 56 */         int red = pixel >> 16 & 0xFF;
/* 57 */         int green = pixel >> 8 & 0xFF;
/* 58 */         int blue = pixel & 0xFF;
/* 59 */         if ((red == 0) && (green == 0) && (blue == 0)) addTile(new Wall(x * 64, y * 64, 64, 64, true, Id.wall, this));
/* 60 */         if ((red == 0) && (green == 0) && (blue == 255)) addEntity(new Player(x * 64, y * 64, 64, 64, false, Id.player, this));
/* 61 */         if (((red == 255 ? 1 : 0) & (green == 0 ? 1 : 0) & (blue == 0 ? 1 : 0)) != 0) addEntity(new Capsule(x * 64, y * 64, 32, 32, true, Id.capsule, this));
/*    */       }
/*    */   }
/*    */ }

/* Location:           E:\Desktop\New folder (4)\New folder\Spooky Outbreak.jar
 * Qualified Name:     com.game.Handler
 * JD-Core Version:    0.6.2
 */