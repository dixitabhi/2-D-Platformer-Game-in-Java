/*    */ package com.game.entity.powerup;
/*    */ 
/*    */ import com.game.Game;
/*    */ import com.game.Handler;
/*    */ import com.game.Id;
/*    */ import com.game.entity.Entity;
/*    */ import com.game.gfx.Sprite;
/*    */ import com.game.tile.Tile;
/*    */ import java.awt.Graphics;
/*    */ import java.awt.Rectangle;
/*    */ 
/*    */ public class Capsule extends Entity
/*    */ {
/*    */   public Capsule(int x, int y, int width, int height, boolean solid, Id id, Handler handler)
/*    */   {
/* 14 */     super(x, y, width, height, solid, id, handler);
/*    */   }
/*    */ 
/*    */   public void render(Graphics g)
/*    */   {
/* 21 */     g.drawImage(Game.capsule.getBufferedImage(), this.x, this.y, this.width, this.height, null);
/*    */   }
/*    */ 
/*    */   public void tick()
/*    */   {
/* 26 */     this.x += this.VelX;
/* 27 */     this.y += this.VelY;
/*    */ 
/* 29 */     for (Tile t : this.handler.tile) {
/* 30 */       if (!t.solid) break;
/* 31 */       if (t.getId() == Id.wall)
/*    */       {
/* 33 */         if (getBoundsBottom().intersects(t.getBounds())) {
/* 34 */           setVelY(0);
/* 35 */           if (this.falling) this.falling = false;
/*    */         }
/* 37 */         else if ((!this.falling) && (!this.jumping)) {
/* 38 */           this.gravity = 0.8D;
/* 39 */           this.falling = true;
/*    */         }
/*    */ 
/* 42 */         if (getBoundsLeft().intersects(t.getBounds())) {
/* 43 */           setVelX(5);
/*    */         }
/*    */ 
/* 46 */         if (getBoundsRight().intersects(t.getBounds()))
/* 47 */           setVelX(-5);
/*    */       }
/*    */     }
/*    */   }
/*    */ }

/* Location:           E:\Desktop\New folder (4)\New folder\Spooky Outbreak.jar
 * Qualified Name:     com.game.entity.powerup.Capsule
 * JD-Core Version:    0.6.2
 */