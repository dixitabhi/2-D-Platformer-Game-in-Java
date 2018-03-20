/*    */ package com.game;
/*    */ 
/*    */ import com.game.entity.Entity;
/*    */ 
/*    */ public class Camera
/*    */ {
/*    */   public int x;
/*    */   public int y;
/*    */ 
/*    */   public void tick(Entity player)
/*    */   {
/* 10 */     setX(-player.getX() + 170);
/* 11 */     setY(-player.getY() + 96);
/*    */   }
/*    */ 
/*    */   public int getX()
/*    */   {
/* 16 */     return this.x;
/*    */   }
/*    */ 
/*    */   public void setX(int x) {
/* 20 */     this.x = x;
/*    */   }
/*    */ 
/*    */   public int getY() {
/* 24 */     return this.y;
/*    */   }
/*    */ 
/*    */   public void setY(int y) {
/* 28 */     this.y = y;
/*    */   }
/*    */ }

/* Location:           E:\Desktop\New folder (4)\New folder\Spooky Outbreak.jar
 * Qualified Name:     com.game.Camera
 * JD-Core Version:    0.6.2
 */