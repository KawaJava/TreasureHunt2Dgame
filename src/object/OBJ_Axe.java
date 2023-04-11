package object;

import entity.Entity;
import java2dgametest.GamePanel;

public class OBJ_Axe extends Entity{
    
    public OBJ_Axe(GamePanel gp) {
        super(gp);
        
        type = type_axe;
        name = "Woodcutter's axe";
        down1 = setup("/objects/axe",gp.tileSize,gp.tileSize);
        attackValue = 250;
        attackArea.width = 30;
        attackArea.height = 30;
        description = "[" + name + "]\nA bit rusty but still \ncan cut some trees.";
        
    }
    
    
    
    
}
