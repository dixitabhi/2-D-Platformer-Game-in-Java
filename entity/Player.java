/*     */ package com.game.entity;
/*     */ 
/*     */ import com.game.Handler;
/*     */ import com.game.Id;
/*     */ import com.game.gfx.Sprite;
/*     */ import com.game.tile.Tile;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Rectangle;
/*     */ import java.util.LinkedList;
/*     */ 
/*     */ public class Player extends Entity
/*     */ {
/*  13 */   private int frame = 0;
/*  14 */   private int frameDelay = 0;
/*  15 */   private boolean animate = false;
/*     */ 
/*     */   public Player(int x, int y, int width, int height, boolean solid, Id id, Handler handler) {
/*  18 */     super(x, y, width, height, solid, id, handler);
/*     */   }
/*     */   public void render(Graphics g) {
/*  21 */     if (this.facing == 0) {
/*  22 */       g.drawImage(com.game.Game.player[(this.frame + 4)].getBufferedImage(), this.x, this.y, this.width, this.height, null);
/*     */     }
/*  25 */     else if (this.facing == 1)
/*  26 */       g.drawImage(com.game.Game.player[this.frame].getBufferedImage(), this.x, this.y, this.width, this.height, null);
/*     */   }
/*     */ 
/*     */   public void tick()
/*     */   {
/*  33 */     this.x += this.VelX;
/*  34 */     this.y += this.VelY;
/*  35 */     if (this.x <= 0) this.x = 0;
/*     */ 
/*  40 */     if (this.VelX != 0) this.animate = true; else {
/*  41 */       this.animate = false;
/*     */     }
/*  43 */     for (Tile t : this.handler.tile) {
/*  44 */       if (!t.solid) break;
/*  45 */       if (t.getId() == Id.wall) {
/*  46 */         if (getBoundsTop().intersects(t.getBounds())) {
/*  47 */           setVelY(0);
/*  48 */           if (this.jumping) {
/*  49 */             this.jumping = false;
/*  50 */             this.gravity = 0.8D;
/*  51 */             this.falling = true;
/*     */           }
/*     */         }
/*     */ 
/*  55 */         if (getBoundsBottom().intersects(t.getBounds())) {
/*  56 */           setVelY(0);
/*  57 */           if (this.falling) this.falling = false;
/*     */         }
/*  59 */         else if ((!this.falling) && (!this.jumping)) {
/*  60 */           this.gravity = 0.8D;
/*  61 */           this.falling = true;
/*     */         }
/*     */ 
/*  64 */         if (getBoundsLeft().intersects(t.getBounds())) {
/*  65 */           setVelX(0);
/*  66 */           this.x = (t.getX() + t.width);
/*     */         }
/*  68 */         if (getBoundsRight().intersects(t.getBounds())) {
/*  69 */           setVelX(0);
/*  70 */           this.x = (t.getX() - t.width);
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/*  77 */     for (int i = 0; i < this.handler.entity.size(); i++) {
/*  78 */       Entity e = (Entity)this.handler.entity.get(i);
/*     */ 
/*  80 */       if ((e.getId() == Id.capsule) && 
/*  81 */         (getBounds().intersects(e.getBounds()))) {
/*  82 */         int tpX = getX();
/*  83 */         int tpY = getY();
/*  84 */         this.width *= 1;
/*  85 */         this.height *= 2;
/*  86 */         setX(tpX - this.width);
/*  87 */         setY(tpY - this.height);
/*  88 */         e.die();
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/*  93 */     if (this.jumping) {
/*  94 */       this.gravity -= 0.1D;
/*  95 */       setVelY((int)-this.gravity);
/*  96 */       if (this.gravity <= 0.0D) {
/*  97 */         this.jumping = false;
/*  98 */         this.falling = true;
/*     */       }
/*     */     }
/* 101 */     if (this.falling) {
/* 102 */       this.gravity += 0.1D;
/* 103 */       setVelY((int)this.gravity);
/*     */     }
/* 105 */     if (this.VelX != 0) {
/* 106 */       this.frameDelay += 1;
/* 107 */       if (this.frameDelay >= 5) {
/* 108 */         this.frame += 1;
/* 109 */         if (this.frame >= 3) {
/* 110 */           this.frame = 0;
/*     */         }
/*     */ 
/* 114 */         this.frameDelay = 0;
/*     */       }
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\Desktop\New folder (4)\New folder\Spooky Outbreak.jar
 * Qualified Name:     com.game.entity.Player
 * JD-Core Version:    0.6.2
 */