/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package object;

import entity.Entity;
import java2dgametest.GamePanel;

/**
 *
 * @author user
 */
public class OBJ_Coin_Bronze extends Entity {
    
    GamePanel gp;
    
    public OBJ_Coin_Bronze(GamePanel gp) {
        super(gp);
        
        this.gp = gp;
        
        type = type_pickupOnly;
        name = "Bronze Coin";
        value = 1;
        down1 = setup("/objects/coin_bronze",gp.tileSize,gp.tileSize);
        
        
        
        
    }
    
    public void use(Entity entity){
        
        gp.playFX(1);
        gp.ui.addMessage("Coin + " + value);
        gp.player.coin += value;
        
    }
    
}
