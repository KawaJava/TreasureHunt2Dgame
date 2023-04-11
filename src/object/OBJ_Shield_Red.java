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
public class OBJ_Shield_Red extends Entity{
    
        public OBJ_Shield_Red(GamePanel gp) {
        super(gp);
        
        type = type_shield;
        name = "Red Shield";
        down1=setup("/objects/shield_red",gp.tileSize,gp.tileSize);
        defenseValue = 2;
        description = "["+ name + "]\nA shiny red shield.";
        
    }
    
}
