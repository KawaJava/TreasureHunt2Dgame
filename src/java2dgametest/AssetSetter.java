package java2dgametest;

import monster.MON_GreenSlime;
import object.OBJ_Axe;
import object.OBJ_Chest;
import object.OBJ_FreezingHammer;
import object.OBJ_Heart;
import object.OBJ_Key;
import object.OBJ_ManaCrystal;
import object.OBJ_Portion_Blue;
import object.OBJ_Shield_Red;
import tile_interactive.IT_DryTree;

public class AssetSetter {

    GamePanel gp;

    public AssetSetter(GamePanel gp) {

        this.gp = gp;

    }

    public void setObject() {

        int i = 0;
        gp.obj[i] = new OBJ_Key(gp);
        gp.obj[i].worldX = 2 * gp.tileSize;
        gp.obj[i].worldY = 2 * gp.tileSize;
        i++;
        
        gp.obj[i] = new OBJ_FreezingHammer(gp);
        gp.obj[i].worldX = 48 * gp.tileSize;
        gp.obj[i].worldY = 22 * gp.tileSize;
        i++;
        
        gp.obj[i] = new OBJ_Axe(gp);
        gp.obj[i].worldX = 48 * gp.tileSize;
        gp.obj[i].worldY = 2 * gp.tileSize;
        i++;
        
        gp.obj[i] = new OBJ_Shield_Red(gp);
        gp.obj[i].worldX = 5 * gp.tileSize;
        gp.obj[i].worldY = 3 * gp.tileSize;
        i++;
        
        gp.obj[i] = new OBJ_Portion_Blue(gp);
        gp.obj[i].worldX = 48 * gp.tileSize;
        gp.obj[i].worldY = 18 * gp.tileSize;
        i++;  
        
        gp.obj[i] = new OBJ_Portion_Blue(gp);
        gp.obj[i].worldX = 47 * gp.tileSize;
        gp.obj[i].worldY = 22 * gp.tileSize;
        i++;
        
        gp.obj[i] = new OBJ_ManaCrystal(gp);
        gp.obj[i].worldX = 20 * gp.tileSize;
        gp.obj[i].worldY = 12 * gp.tileSize;
        i++;
        
        gp.obj[i] = new OBJ_ManaCrystal(gp);
        gp.obj[i].worldX = 21 * gp.tileSize;
        gp.obj[i].worldY = 12 * gp.tileSize;
        i++;
        
        gp.obj[i] = new OBJ_ManaCrystal(gp);
        gp.obj[i].worldX = 22 * gp.tileSize;
        gp.obj[i].worldY = 12 * gp.tileSize;
        i++;
        
        gp.obj[i] = new OBJ_ManaCrystal(gp);
        gp.obj[i].worldX = 23 * gp.tileSize;
        gp.obj[i].worldY = 12 * gp.tileSize;
        i++;
        
        gp.obj[i] = new OBJ_ManaCrystal(gp);
        gp.obj[i].worldX = 20 * gp.tileSize;
        gp.obj[i].worldY = 27 * gp.tileSize;
        i++;
        
        gp.obj[i] = new OBJ_ManaCrystal(gp);
        gp.obj[i].worldX = 21 * gp.tileSize;
        gp.obj[i].worldY = 27 * gp.tileSize;
        i++;
        
        gp.obj[i] = new OBJ_ManaCrystal(gp);
        gp.obj[i].worldX = 22 * gp.tileSize;
        gp.obj[i].worldY = 27 * gp.tileSize;
        i++;
        
        gp.obj[i] = new OBJ_ManaCrystal(gp);
        gp.obj[i].worldX = 23 * gp.tileSize;
        gp.obj[i].worldY = 27 * gp.tileSize;
        i++;
        
        gp.obj[i] = new OBJ_Heart(gp);
        gp.obj[i].worldX = 48 * gp.tileSize;
        gp.obj[i].worldY = 7 * gp.tileSize;
        i++;
        
        gp.obj[i] = new OBJ_Chest(gp);
        gp.obj[i].worldX = 48 * gp.tileSize;
        gp.obj[i].worldY = 38 * gp.tileSize;
        i++;
        
    }

    public void setNPC() {

//        gp.npc[0] = new NPC_OldMan(gp);
//        gp.npc[0].worldX = gp.tileSize * 5;
//        gp.npc[0].worldY = gp.tileSize * 3;

//        gp.npc[1]=new NPC_OldMan(gp);
//        gp.npc[1].worldX=gp.tileSize*2;
//        gp.npc[1].worldY=gp.tileSize*2;
    }

    public void setMonster() {

        int i = 0;
        gp.monster[i] = new MON_GreenSlime(gp);
        gp.monster[i].worldX = gp.tileSize * 30;
        gp.monster[i].worldY = gp.tileSize * 3;
        i++;

        gp.monster[i] = new MON_GreenSlime(gp);
        gp.monster[i].worldX = gp.tileSize * 32;
        gp.monster[i].worldY = gp.tileSize * 3;
        i++;

        gp.monster[i] = new MON_GreenSlime(gp);
        gp.monster[i].worldX = gp.tileSize * 36;
        gp.monster[i].worldY = gp.tileSize * 4;
        i++;
        
        gp.monster[i] = new MON_GreenSlime(gp);
        gp.monster[i].worldX = gp.tileSize * 20;
        gp.monster[i].worldY = gp.tileSize * 19;
        i++;

        gp.monster[i] = new MON_GreenSlime(gp);
        gp.monster[i].worldX = gp.tileSize * 21;
        gp.monster[i].worldY = gp.tileSize * 20;
        i++;

        gp.monster[i] = new MON_GreenSlime(gp);
        gp.monster[i].worldX = gp.tileSize * 20;
        gp.monster[i].worldY = gp.tileSize * 21;
        i++;
        
        gp.monster[i] = new MON_GreenSlime(gp);
        gp.monster[i].worldX = gp.tileSize * 20;
        gp.monster[i].worldY = gp.tileSize * 38;
        i++;

        gp.monster[i] = new MON_GreenSlime(gp);
        gp.monster[i].worldX = gp.tileSize * 22;
        gp.monster[i].worldY = gp.tileSize * 38;
        i++;

        gp.monster[i] = new MON_GreenSlime(gp);
        gp.monster[i].worldX = gp.tileSize * 24;
        gp.monster[i].worldY = gp.tileSize * 38;
        i++;
        
        gp.monster[i] = new MON_GreenSlime(gp);
        gp.monster[i].worldX = gp.tileSize * 20;
        gp.monster[i].worldY = gp.tileSize * 36;
        i++;

        gp.monster[i] = new MON_GreenSlime(gp);
        gp.monster[i].worldX = gp.tileSize * 22;
        gp.monster[i].worldY = gp.tileSize * 36;
        i++;

        gp.monster[i] = new MON_GreenSlime(gp);
        gp.monster[i].worldX = gp.tileSize * 24;
        gp.monster[i].worldY = gp.tileSize * 36;
        i++;

    }
    public void setInteractiveTile(){
        
        int i = 0;
        gp.iTile[i] = new IT_DryTree(gp, 12, 3); i++;
        gp.iTile[i] = new IT_DryTree(gp, 12, 4); i++;
        gp.iTile[i] = new IT_DryTree(gp, 12, 5); i++;
        gp.iTile[i] = new IT_DryTree(gp, 12, 6); i++;
        gp.iTile[i] = new IT_DryTree(gp, 4, 4); i++;
        
        
    }
}
