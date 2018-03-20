/*    */ package com.game.tile;
/*    */ 
/*    */ import com.game.Game;
/*    */ import com.game.Handler;
/*    */ import com.game.Id;
/*    */ import com.game.gfx.Sprite;
/*    */ import java.awt.Graphics;
/*    */ 
/*    */ public class Wall extends Tile
/*    */ {
/*    */   public Wall(int x, int y, int width, int height, boolean solid, Id id, Handler handler)
/*    */   {
/* 12 */     super(x, y, width, height, solid, id, handler);
/*    */   }
/*    */ 
/*    */   public void render(Graphics g)
/*    */   {
/* 18 */     g.drawImage(Game.grass.getBufferedImage(), this.x, this.y, this.width, this.height, null);
/*    */   }
/*    */ 
/*    */   public void tick()
/*    */   {
/*    */   }
/*    */ }

/* Location:           E:\Desktop\New folder (4)\New folder\Spooky Outbreak.jar
 * Qualified Name:     com.game.tile.Wall
 * JD-Core Version:    0.6.2
 */