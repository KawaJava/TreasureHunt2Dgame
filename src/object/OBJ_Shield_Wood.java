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
public class OBJ_Shield_Wood extends Entity {
    
    public OBJ_Shield_Wood(GamePanel gp) {
        super(gp);
        
        type = type_shield;
        name = "Wood Shield";
        down1=setup("/objects/shield_wood",gp.tileSize,gp.tileSize);
        defenseValue = 1;
        description = "["+ name + "]\nMade by wood.";
        
    }
    
    
}
