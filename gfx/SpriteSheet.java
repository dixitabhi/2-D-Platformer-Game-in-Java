/*    */ package com.game.gfx;
/*    */ 
/*    */ import java.awt.image.BufferedImage;
/*    */ import java.io.IOException;
/*    */ import javax.imageio.ImageIO;
/*    */ 
/*    */ public class SpriteSheet
/*    */ {
/*    */   private BufferedImage sheet;
/*    */ 
/*    */   public SpriteSheet(String path)
/*    */   {
/*    */     try
/*    */     {
/* 14 */       this.sheet = ImageIO.read(getClass().getResourceAsStream(path));
/*    */     } catch (IOException e) {
/* 16 */       e.printStackTrace();
/*    */     }
/*    */   }
/*    */ 
/*    */   public BufferedImage getSprite(int x, int y) {
/* 21 */     return this.sheet.getSubimage(x * 64 - 64, y * 64 - 64, 64, 64);
/*    */   }
/*    */ }

/* Location:           E:\Desktop\New folder (4)\New folder\Spooky Outbreak.jar
 * Qualified Name:     com.game.gfx.SpriteSheet
 * JD-Core Version:    0.6.2
 */