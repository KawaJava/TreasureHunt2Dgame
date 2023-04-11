package object;

import entity.Entity;
import java2dgametest.GamePanel;

public class OBJ_Door extends Entity{
    
    GamePanel gp;
    
        public OBJ_Door(GamePanel gp){
        
//        this.gp=gp;    
        super(gp);
        
        name="Door";
        down1=setup("/objects/door",gp.tileSize,gp.tileSize);
        

        collision=true;
        
    }
    
}
