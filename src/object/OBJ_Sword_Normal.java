package object;

import entity.Entity;
import java2dgametest.GamePanel;

public class OBJ_Sword_Normal extends Entity {

    public OBJ_Sword_Normal(GamePanel gp) {
        super(gp);

        type = type_sword;
        name = "normal";
        down1 = setup("/objects/sword_normal", gp.tileSize, gp.tileSize);
        attackValue = 90; //4
        attackArea.width = 36;
        attackArea.height = 36;
        description = "[" + name + "]\nAn old sword.";
        
    }

}
