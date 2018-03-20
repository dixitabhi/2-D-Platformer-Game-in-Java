/*    */ package com.game.entity;
/*    */ 
/*    */ import com.game.Handler;
/*    */ import com.game.Id;
/*    */ import java.awt.Graphics;
/*    */ import java.awt.Rectangle;
/*    */ 
/*    */ public abstract class Entity
/*    */ {
/*    */   protected int x;
/*    */   protected int y;
/*    */   public int width;
/*    */   public int height;
/* 13 */   public int facing = 0;
/*    */   public int VelX;
/*    */   public int VelY;
/*    */   private boolean solid;
/* 17 */   public boolean jumping = false;
/* 18 */   public boolean falling = true;
/*    */   public Id id;
/* 20 */   public double gravity = 0.0D;
/*    */   public Handler handler;
/*    */ 
/*    */   public Entity(int x, int y, int width, int height, boolean solid, Id id, Handler handler)
/*    */   {
/* 24 */     this.x = x;
/* 25 */     this.y = y;
/* 26 */     this.width = width;
/* 27 */     this.height = height;
/* 28 */     this.solid = solid;
/* 29 */     this.id = id;
/* 30 */     this.handler = handler;
/*    */   }
/*    */   public abstract void render(Graphics paramGraphics);
/*    */ 
/*    */   public abstract void tick();
/*    */ 
/*    */   public void die() {
/* 37 */     this.handler.removeEntity(this);
/*    */   }
/*    */ 
/*    */   public int getX()
/*    */   {
/* 42 */     return this.x;
/*    */   }
/*    */ 
/*    */   public void setX(int x)
/*    */   {
/* 47 */     this.x = x;
/*    */   }
/*    */ 
/*    */   public int getY() {
/* 51 */     return this.y;
/*    */   }
/*    */ 
/*    */   public void setY(int y)
/*    */   {
/* 56 */     this.y = y;
/*    */   }
/*    */ 
/*    */   public Id getId() {
/* 60 */     return this.id;
/*    */   }
/*    */ 
/*    */   public boolean isSolid() {
/* 64 */     return this.solid;
/*    */   }
/*    */ 
/*    */   public void setVelX(int VelX)
/*    */   {
/* 70 */     this.VelX = VelX;
/*    */   }
/*    */ 
/*    */   public void setVelY(int VelY) {
/* 74 */     this.VelY = VelY;
/*    */   }
/*    */ 
/*    */   public Rectangle getBounds() {
/* 78 */     return new Rectangle(this.x, this.y, this.width, this.height);
/*    */   }
/*    */   public Rectangle getBoundsTop() {
/* 81 */     return new Rectangle(getX() + 10, getY(), this.width - 20, 5);
/*    */   }
/*    */   public Rectangle getBoundsBottom() {
/* 84 */     return new Rectangle(getX() + 10, getY() + this.height - 5, this.width - 20, 5);
/*    */   }
/*    */   public Rectangle getBoundsLeft() {
/* 87 */     return new Rectangle(getX(), getY() + 10, 5, this.height - 20);
/*    */   }
/*    */   public Rectangle getBoundsRight() {
/* 90 */     return new Rectangle(getX() + this.width - 5, getY() + 10, 5, this.height - 20);
/*    */   }
/*    */ }

/* Location:           E:\Desktop\New folder (4)\New folder\Spooky Outbreak.jar
 * Qualified Name:     com.game.entity.Entity
 * JD-Core Version:    0.6.2
 */