/*    */ package com.game.gfx;
/*    */ 
/*    */ import java.awt.image.BufferedImage;
/*    */ 
/*    */ public class Sprite
/*    */ {
/*    */   public SpriteSheet sheet;
/*    */   public BufferedImage image;
/*    */ 
/*    */   public Sprite(SpriteSheet sheet, int x, int y)
/*    */   {
/* 12 */     this.image = sheet.getSprite(x, y);
/*    */   }
/*    */   public BufferedImage getBufferedImage() {
/* 15 */     return this.image;
/*    */   }
/*    */ }

/* Location:           E:\Desktop\New folder (4)\New folder\Spooky Outbreak.jar
 * Qualified Name:     com.game.gfx.Sprite
 * JD-Core Version:    0.6.2
 */