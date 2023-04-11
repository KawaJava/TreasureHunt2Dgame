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
public class OBJ_Portion_Blue extends Entity{
    
    GamePanel gp;
    
    public OBJ_Portion_Blue(GamePanel gp) {
        super(gp);
        
        this.gp = gp;
        
        type = type_consumable;
        name = "Blue Portion";
        value = 500;
        down1=setup("/objects/portion_blue",gp.tileSize,gp.tileSize);
        description = "["+ name + "]\nHeals your life by " + value + ".";
        
    }
    public void use(Entity entity){
        
        gp.gameState = gp.dialogueState;
        gp.ui.currentDialogue = "You drink the " + name + ".\n" + "Your life has been recovered by " + value + ".";
        entity.life += value;
        
    }
    
    
}
