package object;

import entity.Entity;
import java2dgametest.GamePanel;

public class OBJ_Chest extends Entity{
    
    GamePanel gp;
    
    public OBJ_Chest(GamePanel gp){
        
        super(gp);
        this.gp = gp;
        
        name = "Chest";
        down1 = setup("/objects/chest",gp.tileSize,gp.tileSize);
        collision = true;
        type = type_pickupOnly;
        
    }
    
    public void use(Entity entity){
        
        gp.stopMusic();
        gp.playMusic(4);
        gp.gameState = gp.winState;
        
    }
        
}
