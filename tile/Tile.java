/*    */ package com.game.tile;
/*    */ 
/*    */ import com.game.Handler;
/*    */ import com.game.Id;
/*    */ import java.awt.Graphics;
/*    */ import java.awt.Rectangle;
/*    */ 
/*    */ public abstract class Tile
/*    */ {
/*    */   protected int x;
/*    */   protected int y;
/*    */   public int width;
/*    */   public int height;
/*    */   private int VelX;
/*    */   private int VelY;
/*    */   public boolean solid;
/*    */   public Id id;
/*    */   public Handler handler;
/*    */ 
/*    */   public Tile(int x, int y, int width, int height, boolean solid, Id id, Handler handler)
/*    */   {
/* 20 */     this.x = x;
/* 21 */     this.y = y;
/* 22 */     this.width = width;
/* 23 */     this.height = height;
/* 24 */     this.solid = solid;
/* 25 */     this.id = id;
/* 26 */     this.handler = handler;
/*    */   }
/*    */   public abstract void render(Graphics paramGraphics);
/*    */ 
/*    */   public abstract void tick();
/*    */ 
/*    */   public void die() {
/* 33 */     this.handler.removeTile(this);
/*    */   }
/*    */ 
/*    */   public int getX() {
/* 37 */     return this.x;
/*    */   }
/*    */ 
/*    */   public void setX(int x)
/*    */   {
/* 42 */     this.x = x;
/*    */   }
/*    */ 
/*    */   public int getY() {
/* 46 */     return this.y;
/*    */   }
/*    */ 
/*    */   public void setY(int y)
/*    */   {
/* 51 */     this.y = y;
/*    */   }
/*    */ 
/*    */   public Id getId() {
/* 55 */     return this.id;
/*    */   }
/*    */ 
/*    */   public boolean isSolid() {
/* 59 */     return this.solid;
/*    */   }
/*    */ 
/*    */   public void setVelX(int VelX)
/*    */   {
/* 66 */     this.VelX = VelX;
/*    */   }
/*    */ 
/*    */   public void setVelY(int VelY) {
/* 70 */     this.VelY = VelY;
/*    */   }
/*    */   public Rectangle getBounds() {
/* 73 */     return new Rectangle(getX(), getY(), this.width, this.height);
/*    */   }
/*    */ }

/* Location:           E:\Desktop\New folder (4)\New folder\Spooky Outbreak.jar
 * Qualified Name:     com.game.tile.Tile
 * JD-Core Version:    0.6.2
 */