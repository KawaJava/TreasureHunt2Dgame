package entity;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java2dgametest.DamageCalculator;
import java2dgametest.GamePanel;
import java2dgametest.KeyHandler;
import object.OBJ_Fireball;
import object.OBJ_Key;
import object.OBJ_Shield_Wood;
import object.OBJ_Sword_Normal;

public class Player extends Entity {

    KeyHandler keyH;

    public final int screenX;
    public final int screenY;
    //public int hasKey = 0;
    boolean moving = false;
    int pixelCounter = 0;
    public boolean attackCanceled = false;
    public ArrayList<Entity> inventory = new ArrayList<>();
    public final int maxInventorySize = 20;
    public DamageCalculator DamageCalculator = new DamageCalculator();
    public int totalDamage = 0;

    public Player(GamePanel gp, KeyHandler keyH) {

        super(gp);
        //this.gp = gp;
        this.keyH = keyH;

        screenX = gp.screenWidth / 2 - (gp.tileSize / 2);
        screenY = gp.screenHeight / 2 - (gp.tileSize / 2);

        solidArea = new Rectangle();
        solidArea.x = 8; //1
        solidArea.y = 16; //1
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.height = 28; //46
        solidArea.width = 28; //46

//        attackArea.width = 36; //48
//        attackArea.height = 36; //48
        setDefaultValues();
        getPlayerImage();
        getPlayerAttackImage();
        setItems();

    }

    public void setDefaultValues() {
        worldX = gp.tileSize * 3;
        worldY = gp.tileSize * 2;
        speed = 4;
        direction = "down";

        //PLAYER STATUS
        level = 1;
        maxLife = 1200;
        life = maxLife;
        maxMana = 4;
        mana = maxMana;
        strenght = 1;
        dexterity = 1;
        exp = 0;
        nextLevelExp = 5;
        coin = 0;
        currentWeapon = new OBJ_Sword_Normal(gp);
        currentShield = new OBJ_Shield_Wood(gp);
        projectile = new OBJ_Fireball(gp);
        attack = getAttack();
        defense = getDefense();

    }

    public void setItems() {

        inventory.add(currentWeapon);
        inventory.add(currentShield);
        inventory.add(new OBJ_Key(gp));

    }

    public int getAttack() {
        attackArea = currentWeapon.attackArea;
        //return attack = strenght * currentWeapon.attackValue;
        return attack = currentWeapon.attackValue;
    }

    public int getDefense() {
        //return defense = dexterity * currentShield.defenseValue;
        return defense = dexterity * currentShield.defenseValue;
    }

    public void getPlayerImage() {

        up1 = setup("/player/boy_up_1", gp.tileSize, gp.tileSize);
        up2 = setup("/player/boy_up_2", gp.tileSize, gp.tileSize);
        down1 = setup("/player/boy_down_1", gp.tileSize, gp.tileSize);
        down2 = setup("/player/boy_down_2", gp.tileSize, gp.tileSize);
        left1 = setup("/player/boy_left_1", gp.tileSize, gp.tileSize);
        left2 = setup("/player/boy_left_2", gp.tileSize, gp.tileSize);
        right1 = setup("/player/boy_right_1", gp.tileSize, gp.tileSize);
        right2 = setup("/player/boy_right_2", gp.tileSize, gp.tileSize);

    }

    public void getPlayerAttackImage() {

        if (currentWeapon.type == type_sword) {
            attackUp1 = setup("/player/boy_attack_up_1", gp.tileSize, gp.tileSize * 2);
            attackUp2 = setup("/player/boy_attack_up_2", gp.tileSize, gp.tileSize * 2);
            attackDown1 = setup("/player/boy_attack_down_1", gp.tileSize, gp.tileSize * 2);
            attackDown2 = setup("/player/boy_attack_down_2", gp.tileSize, gp.tileSize * 2);
            attackLeft1 = setup("/player/boy_attack_left_1", gp.tileSize * 2, gp.tileSize);
            attackLeft2 = setup("/player/boy_attack_left_2", gp.tileSize * 2, gp.tileSize);
            attackRight1 = setup("/player/boy_attack_right_1", gp.tileSize * 2, gp.tileSize);
            attackRight2 = setup("/player/boy_attack_right_2", gp.tileSize * 2, gp.tileSize);
        }
        if (currentWeapon.type == type_axe) {
            attackUp1 = setup("/player/boy_axe_up_1", gp.tileSize, gp.tileSize * 2);
            attackUp2 = setup("/player/boy_axe_up_2", gp.tileSize, gp.tileSize * 2);
            attackDown1 = setup("/player/boy_axe_down_1", gp.tileSize, gp.tileSize * 2);
            attackDown2 = setup("/player/boy_axe_down_2", gp.tileSize, gp.tileSize * 2);
            attackLeft1 = setup("/player/boy_axe_left_1", gp.tileSize * 2, gp.tileSize);
            attackLeft2 = setup("/player/boy_axe_left_2", gp.tileSize * 2, gp.tileSize);
            attackRight1 = setup("/player/boy_axe_right_1", gp.tileSize * 2, gp.tileSize);
            attackRight2 = setup("/player/boy_axe_right_2", gp.tileSize * 2, gp.tileSize);
        }
        if (currentWeapon.type == type_freezer) {
            attackUp1 = setup("/player/boy_freezer_up_1", gp.tileSize, gp.tileSize * 2);
            attackUp2 = setup("/player/boy_freezer_up_2", gp.tileSize, gp.tileSize * 2);
            attackDown1 = setup("/player/boy_freezer_down_1", gp.tileSize, gp.tileSize * 2);
            attackDown2 = setup("/player/boy_freezer_down_2", gp.tileSize, gp.tileSize * 2);
            attackLeft1 = setup("/player/boy_freezer_left_1", gp.tileSize * 2, gp.tileSize);
            attackLeft2 = setup("/player/boy_freezer_left_2", gp.tileSize * 2, gp.tileSize);
            attackRight1 = setup("/player/boy_freezer_right_1", gp.tileSize * 2, gp.tileSize);
            attackRight2 = setup("/player/boy_freezer_right_2", gp.tileSize * 2, gp.tileSize);
        }

    }

    public void update() {

        if (attacking == true) {
            attacking();
        } else if (keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true
                || keyH.rightPressed == true || keyH.attackKeyPressed == true) {

            if (keyH.upPressed == true) {
                direction = "up";

            } else if (keyH.downPressed == true) {
                direction = "down";

            } else if (keyH.leftPressed == true) {
                direction = "left";

            } else if (keyH.rightPressed == true) {
                direction = "right";

            }

            //CHECK TILE COLLISION
            collisionOn = false;
            gp.cChecker.checkTile(this);

            //CHECK OBJECT COLLISION
            int objIndex = gp.cChecker.checkObject(this, true);
            pickUpObject(objIndex);

            //CHECK NPC COLLISION
            int npcIndex = gp.cChecker.checkEntity(this, gp.npc);
            interactNPC(npcIndex);

            //CHECK MONSTER COLLISION
            int monsterIndex = gp.cChecker.checkEntity(this, gp.monster);
            contactMonster(monsterIndex);

            //CHECK INTERACTIVE TILE COLLISION
            int iTileIndex = gp.cChecker.checkEntity(this, gp.iTile);

            //CHECK EVENT
            gp.eHandler.checkEvent();

            if (collisionOn == false && keyH.enterPressed == false) {
                switch (direction) {
                    case "up":
                        worldY -= speed;
                        break;
                    case "down":
                        worldY += speed;
                        break;
                    case "left":
                        worldX -= speed;
                        break;
                    case "right":
                        worldX += speed;
                        break;

                }
            }

            if (keyH.attackKeyPressed == true && attackCanceled == false) {

                attacking = true;
                spriteCounter = 0;

            }

            attackCanceled = false;

            gp.keyH.attackKeyPressed = false;

            spriteCounter++;
            if (spriteCounter > 10) {
                if (spriteNum == 1) {
                    spriteNum = 2;
                } else if (spriteNum == 2) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }

        if (gp.keyH.shotKeyPressed == true && projectile.alive == false && shotAvailbleCounter == 30 && projectile.haveResource(this) == true) {

            projectile.set(worldX, worldY, direction, true, this);

            projectile.subtrackResource(this);

            gp.projectileList.add(projectile);

            shotAvailbleCounter = 0;

            gp.playFX(13);

        }

        if (invincible == true) {

            invincibleCounter++;
            if (invincibleCounter > 60) {
                invincible = false;
                invincibleCounter = 0;
            }

        }

        if (shotAvailbleCounter < 30) {
            shotAvailbleCounter++;
        }
        if (life > maxLife) {
            life = maxLife;
        }
        if (mana > maxMana) {
            mana = maxMana;
        }
        
        checkLost();
        
    }

    public void attacking() {

        spriteCounter++;
        if (spriteCounter == 5) {
            gp.playFX(3);
        }

        if (spriteCounter <= 5) {
            spriteNum = 1;
        }
        if (spriteCounter > 5 && spriteCounter <= 25) {
            spriteNum = 2;

            int CurrnetWorldX = worldX;
            int CurrnetWorldY = worldY;
            int solidAreaWidth = solidArea.width;
            int solidAreaHeight = solidArea.height;

            switch (direction) {
                case "up":
                    worldY -= solidArea.height;
                    break;
                case "down":
                    worldY += solidArea.height;
                    break;
                case "left":
                    worldX -= solidArea.width;
                    break;
                case "right":
                    worldX += solidArea.width;
                    break;
            }

            solidArea.width = attackArea.width;
            solidArea.height = attackArea.height;

            int monsterIndex = gp.cChecker.checkEntity(this, gp.monster);
            damageMonster(monsterIndex, attack);

            int iTileIndex = gp.cChecker.checkEntity(this, gp.iTile);
            damageInteractiveTile(iTileIndex);

            worldX = CurrnetWorldX;
            worldY = CurrnetWorldY;
            solidArea.width = solidAreaWidth;
            solidArea.height = solidAreaHeight;

        }
        if (spriteCounter > 25) {
            spriteNum = 1;
            spriteCounter = 0;
            attacking = false;
        }

    }

    public void pickUpObject(int i) {

        if (i != 999) {

            // PICKUP ONLY ITEMS
            if (gp.obj[i].type == type_pickupOnly) {

                gp.obj[i].use(this);
                gp.obj[i] = null;

            } //INVENTORY ITEMS
            else {

                String text;

                if (inventory.size() != maxInventorySize) {

                    inventory.add(gp.obj[i]);
                    gp.playFX(1);
                    text = "Got a " + gp.obj[i].name + ".";

                } else {
                    text = "You cannot carry any more";
                }
                gp.ui.addMessage(text);
                gp.obj[i] = null;

            }

//            String objectName = gp.obj[i].name;
//            switch (objectName) {
//                case "Key":
//                    gp.playFX(1);
//                    hasKey++;
//                    gp.obj[i] = null;
//                    gp.ui.drawMessage("You got a key!");
//                    break;
//                case "Door":
//                    if (hasKey > 0) {
//                        gp.playFX(2);
//                        gp.obj[i] = null;
//                        hasKey--;
//                        gp.ui.drawMessage("You opened the door!");
//                    } else {
//                        gp.ui.drawMessage("You need a key!");
//                    }
//                    break;
//                case "Chest":
//                    gp.stopMusic();
//                    gp.playFX(3);
//                    gp.obj[i] = null;
//                    gp.ui.gameFinished = true;
//                    System.out.println("Win!");
//                    gp.playMusic(4);
//
//                    break;
//
//            }
        }

    }

    public void interactNPC(int i) {

        if (gp.keyH.enterPressed == true) {
            if (i != 999) {
                attackCanceled = true;
                gp.gameState = gp.dialogueState;
                gp.npc[i].speak();
            }
//            else {
//                gp.playFX(3);
//                attacking = true;
//            }
        }

    }

    public void contactMonster(int i) {

        if (i != 999) {

            if (invincible == false && gp.monster[i].dying == false && gp.monster[i].frozen == false) {

                int randomAttack = DamageCalculator.giveRandomDamage(gp.monster[i].attack);
                int damage = randomAttack - gp.player.defense;
                if (damage < 0) {
                    damage = 0;
                }

                life -= damage;
                invincible = true;
                gp.stopSpeech();
                gp.playSpeech(8);

            }

        }

    }

    public void damageMonster(int i, int attack) {

        if (i != 999) {

            if (gp.monster[i].invincible == false) {

                int randomAttack = DamageCalculator.giveRandomDamage(attack);
                int damage = randomAttack - gp.monster[i].defense;

                if (currentWeapon.type == type_freezer) {
                    if (gp.monster[i].frozen == true) {
                        gp.monster[i].frozen = false;
                        gp.monster[i].invincible = true;
                        //gp.monster[i].direction = this.direction;
                        gp.monster[i].damageReaction();

                        gp.ui.addMessage("You have unfrozen the " + gp.monster[i].name);

                    } else {
                        gp.monster[i].frozen = true;
                        gp.monster[i].invincible = true;
                        gp.monster[i].life -= damage;
                        totalDamage += damage;
                        gp.ui.addMessage(damage + " damage");
                        gp.playFX(15);
                        gp.ui.addMessage("You have frozen the " + gp.monster[i].name);
                    }

                } else {

                    if (gp.monster[i].life > damage) {
                        gp.monster[i].life -= damage;
                    } else {
                        damage = gp.monster[i].life;
                        gp.monster[i].life = 0;
                    }
                    totalDamage += damage;
                    gp.ui.addMessage(damage + " damage");
                    gp.monster[i].invincible = true;
                    if (gp.monster[i].frozen == false) {
//                        gp.stopSpeech();
//                        gp.playSpeech(11);

                        gp.monster[i].damageReaction();
                    }

                    if (gp.monster[i].life <= 0) {
                        gp.monster[i].dying = true;
                        gp.ui.addMessage("killed the " + gp.monster[i].name);
                        gp.ui.addMessage("Exp + " + gp.monster[i].exp);
                        exp += gp.monster[i].exp;
                        checkLevelUp();
//                    gp.monster[i]=null;
//                    gp.stopSpeech();
//                    gp.playSpeech(10);
                    }

                }

            }

            System.out.println("Hit!");
        } else {
            System.out.println("Miss!");
        }

    }

    public void damageInteractiveTile(int i) {

        if (i != 999 && gp.iTile[i].destructible == true && gp.iTile[i].isCorrectItem(this) == true && gp.iTile[i].invincible == false) {

//            gp.iTile[i].playFX();
            gp.iTile[i].life--;
            gp.iTile[i].invincible = true;

            if (gp.iTile[i].life == 0) {
                gp.iTile[i] = gp.iTile[i].getDestroyedForm();
            }

        }

    }

    public void checkLevelUp() {

        if (exp >= nextLevelExp) {

            level++;
            nextLevelExp = nextLevelExp * 2;
            maxLife += 50;
            strenght++;
            dexterity++;
            attack = getAttack();
            defense = getDefense();

            gp.playFX(1);
            gp.gameState = gp.dialogueState;
            gp.ui.currentDialogue = "You are level " + level + " now\n"
                    + "You fell stronger";

        }

    }

    public void selectItem() {

        int itemIndex = gp.ui.getItemIndexOnSlot();

        if (itemIndex < inventory.size()) {

            Entity selectedItem = inventory.get(itemIndex);

            if (selectedItem.type == type_sword || selectedItem.type == type_axe || selectedItem.type == type_freezer) {

                currentWeapon = selectedItem;
                attack = getAttack();
                getPlayerAttackImage();

            }
            if (selectedItem.type == type_shield) {

                currentShield = selectedItem;
                defense = getDefense();

            }
            if (selectedItem.type == type_consumable) {

                selectedItem.use(this);
                inventory.remove(itemIndex);

            }

        }

    }

    public void draw(Graphics2D g2) {
        //        g2.setColor(Color.white);
        //        g2.fillRect(x, y, gp.tileSize, gp.tileSize);

        BufferedImage image = null;
        int tempScreenX = screenX;
        int tempScreenY = screenY;

        switch (direction) {
            case "up":
                if (attacking == false) {
                    if (spriteNum == 1) {
                        image = up1;
                    }
                    if (spriteNum == 2) {
                        image = up2;
                    }
                }
                if (attacking == true) {
                    tempScreenY = screenY - gp.tileSize;
                    if (spriteNum == 1) {
                        image = attackUp1;
                    }
                    if (spriteNum == 2) {
                        image = attackUp2;
                    }
                }

                break;
            case "down":
                if (attacking == false) {
                    if (spriteNum == 1) {
                        image = down1;
                    }
                    if (spriteNum == 2) {
                        image = down2;
                    }
                }
                if (attacking == true) {
                    if (spriteNum == 1) {
                        image = attackDown1;
                    }
                    if (spriteNum == 2) {
                        image = attackDown2;
                    }
                }

                break;
            case "left":
                if (attacking == false) {
                    if (spriteNum == 1) {
                        image = left1;
                    }
                    if (spriteNum == 2) {
                        image = left2;
                    }
                }
                if (attacking == true) {
                    tempScreenX = screenX - gp.tileSize;
                    if (spriteNum == 1) {
                        image = attackLeft1;
                    }
                    if (spriteNum == 2) {
                        image = attackLeft2;
                    }
                }

                break;
            case "right":
                if (attacking == false) {
                    if (spriteNum == 1) {
                        image = right1;
                    }
                    if (spriteNum == 2) {
                        image = right2;
                    }
                }
                if (attacking == true) {
                    if (spriteNum == 1) {
                        image = attackRight1;
                    }
                    if (spriteNum == 2) {
                        image = attackRight2;
                    }
                }

                break;
        }
        int x = screenX;
        int y = screenY;

        if (invincible == true) {
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.4f));
        }
        

//        //Stop moving the camera at the edge
//        if (screenX > worldX) {
//            x = worldX;
//        }
//        if (screenY > worldY) {
//            y = worldY;
//        }
//        int rightOffset = gp.screenWidth - gp.player.screenX;
//        if (rightOffset > gp.worldWidth - gp.player.worldX) {
//            x = gp.screenWidth - (gp.worldWidth - worldX);
//        }
//        int bottonOffset = gp.screenHeight - gp.player.screenY;
//        if (bottonOffset > gp.worldHeight - gp.player.worldY) {
//            y = gp.screenHeight - (gp.worldHeight - worldY);
//        }
//        //Stop moving the camera at the edge
        g2.drawImage(image, tempScreenX, tempScreenY, null);
        //g2.drawImage(image, x, y, null);
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
        //gp.keyH.enterPressed=false;

//        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
//        g2.setColor(Color.red);
//        g2.drawRect(screenX+solidArea.x, screenY+solidArea.y, solidArea.width, solidArea.height);
    }

    public void checkLost() {

        if (gp.player.life <= 0) {
            gp.gameState = gp.lostState;
            gp.stopSpeech();
            gp.stopMusic();
            gp.playSpeech(9);
        }

    }
}
