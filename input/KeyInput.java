/*    */ package com.game.input;
/*    */ 
/*    */ import com.game.Game;
/*    */ import com.game.Handler;
/*    */ import com.game.Id;
/*    */ import com.game.entity.Entity;
/*    */ import java.awt.event.KeyEvent;
/*    */ import java.awt.event.KeyListener;
/*    */ 
/*    */ public class KeyInput
/*    */   implements KeyListener
/*    */ {
/*    */   public void keyPressed(KeyEvent ke)
/*    */   {
/* 14 */     int key = ke.getKeyCode();
/* 15 */     for (Entity en : Game.handler.entity)
/* 16 */       if (en.getId() == Id.player)
/* 17 */         switch (key) {
/*    */         case 87:
/* 19 */           if (!en.jumping) {
/* 20 */             en.jumping = true;
/* 21 */             en.gravity = 9.0D;
/*    */           }
/* 23 */           break;
/*    */         case 65:
/* 26 */           en.setVelX(-5);
/* 27 */           en.facing = 0;
/* 28 */           break;
/*    */         case 68:
/* 30 */           en.setVelX(5);
/* 31 */           en.facing = 1;
/*    */         }
/*    */   }
/*    */ 
/*    */   public void keyReleased(KeyEvent e)
/*    */   {
/* 40 */     int key = e.getKeyCode();
/* 41 */     for (Entity en : Game.handler.entity)
/* 42 */       if (en.getId() == Id.player)
/* 43 */         switch (key) {
/*    */         case 87:
/* 45 */           en.setVelY(0);
/* 46 */           break;
/*    */         case 83:
/* 48 */           en.setVelY(0);
/* 49 */           break;
/*    */         case 65:
/* 51 */           en.setVelX(0);
/* 52 */           break;
/*    */         case 68:
/* 54 */           en.setVelX(0);
/*    */         }
/*    */   }
/*    */ 
/*    */   public void keyTyped(KeyEvent ke)
/*    */   {
/*    */   }
/*    */ }

/* Location:           E:\Desktop\New folder (4)\New folder\Spooky Outbreak.jar
 * Qualified Name:     com.game.input.KeyInput
 * JD-Core Version:    0.6.2
 */