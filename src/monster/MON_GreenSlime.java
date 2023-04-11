package monster;

import entity.Entity;
import java.util.Random;
import java2dgametest.GamePanel;
import object.OBJ_Coin_Bronze;
import object.OBJ_Heart;
import object.OBJ_ManaCrystal;
import object.OBJ_Rock;

public class MON_GreenSlime extends Entity {

    GamePanel gp;

    public MON_GreenSlime(GamePanel gp) {
        super(gp);

        this.gp = gp;

        type = type_monster;
        name = "Green Slime";
        speed = 1;
        maxLife = 1500;
        life = maxLife;
        attack = 390;
        defense = 0;
        exp = 2;
        projectile = new OBJ_Rock(gp);

        solidArea.x = 3;
        solidArea.y = 18;
        solidArea.width = 42;
        solidArea.height = 30;

        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        getImage();

    }

    public void getImage() {

        up1 = setup("/monster/monster_up_1", gp.tileSize, gp.tileSize);
        up2 = setup("/monster/monster_up_2", gp.tileSize, gp.tileSize);
        down1 = setup("/monster/monster_up_1", gp.tileSize, gp.tileSize);
        down2 = setup("/monster/monster_up_2", gp.tileSize, gp.tileSize);
        left1 = setup("/monster/monster_up_1", gp.tileSize, gp.tileSize);
        left2 = setup("/monster/monster_up_2", gp.tileSize, gp.tileSize);
        right1 = setup("/monster/monster_up_1", gp.tileSize, gp.tileSize);
        right2 = setup("/monster/monster_up_2", gp.tileSize, gp.tileSize);
        frozen1 = setup("/monster/monster_frozen", gp.tileSize, gp.tileSize);

    }

    public void setAction() {

        actionLockCounter++;
        if (frozen == false) {
            if (actionLockCounter == 120 || collisionOn == true) {
                Random random = new Random();
                int i = random.nextInt(100) + 1;

                if (i <= 25) {
                    direction = "up";
                }
                if (i > 25 && i <= 50) {
                    direction = "down";
                }
                if (i > 50 && i <= 75) {
                    direction = "left";
                }
                if (i > 75 && i <= 100) {
                    direction = "right";
                }
                actionLockCounter = 0;
                int o = new Random().nextInt(100) + 1;

                if (o > 50 && projectile.alive == false && shotAvailbleCounter == 30) {

                    projectile.set(worldX, worldY, direction, true, this);
                    gp.projectileList.add(projectile);
                    shotAvailbleCounter = 0;

                }
            }
        } else {

            if (actionLockCounter == 12 || collisionOn == true) {
                direction = "frozen1";
                actionLockCounter = 0;
            }
            if (actionLockCounter == 12 || collisionOn == false) {
                direction = "frozen1";
                actionLockCounter = 0;
            }
        }

    }

    public void damageReaction() {

        actionLockCounter = 0;
        direction = gp.player.direction;

    }

    public void checkDrop() {

        int i = new Random().nextInt(100) + 1;

        if (i < 50) {
            dropItem(new OBJ_Coin_Bronze(gp));
        }
        if (i >= 50 && i < 75) {
            dropItem(new OBJ_Heart(gp));
        }
        if (i >= 75 && i < 100) {
            dropItem(new OBJ_ManaCrystal(gp));
        }

    }

}
