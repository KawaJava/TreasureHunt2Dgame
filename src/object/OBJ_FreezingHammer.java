package object;

import entity.Entity;
import java2dgametest.GamePanel;

public class OBJ_FreezingHammer extends Entity{
    
    public OBJ_FreezingHammer(GamePanel gp) {
        super(gp);
        
        type = type_freezer;
        name = "Freezing hammer";
        down1 = setup("/objects/freezinghammer",gp.tileSize,gp.tileSize);
        attackValue = 100;
        attackArea.width = 30;
        attackArea.height = 30;
        description = "[" + name + "]\nThis can freeze \nmonsters.";
    }
    
}
