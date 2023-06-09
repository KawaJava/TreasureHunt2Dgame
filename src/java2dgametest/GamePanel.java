package java2dgametest;

import entity.Entity;
import entity.Player;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JPanel;
import tile.TileManager;
import tile_interactive.InteractiveTile;

public class GamePanel extends JPanel implements Runnable {

    // SETTINGS
    final int originalTileSize = 16;
    final int scale = 3;

    public final int tileSize = originalTileSize * scale; //48x48
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol; //768
    public final int screenHeight = tileSize * maxScreenRow; //576

    //WORLD MAP PARAMETERS
    public final int maxWorldCol = 50;
    public final int maxWorldRow = 40;
    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRow;

    //FPS
    int FPS = 60;

    TileManager TileM = new TileManager(this);

    public KeyHandler keyH = new KeyHandler(this);
    Sound music = new Sound();
    Sound fx = new Sound();
    Sound speech = new Sound();
    public CollisionChecker cChecker = new CollisionChecker(this);
    public AssetSetter ASetter = new AssetSetter(this);
    public UI ui = new UI(this);
    public EventHandler eHandler = new EventHandler(this);
    Thread gameThread;

    public Player player = new Player(this, keyH);
    public Entity obj[] = new Entity[20];
    public Entity npc[] = new Entity[10];
    public Entity monster[] = new Entity[20];
    public InteractiveTile iTile[] = new InteractiveTile[50];
    public ArrayList<Entity> projectileList = new ArrayList<>();
    ArrayList<Entity> entityList = new ArrayList<>();

    // GAME STATE
    public int gameState;
    public final int titleState = 0;
    public final int playState = 1;
    public final int pauseState = 2;
    public final int dialogueState = 3;
    public final int characterState = 4;
    public final int lostState = 5;
    public final int winState = 6;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void setupGame() {

        ASetter.setObject();
        ASetter.setNPC();
        ASetter.setMonster();
        ASetter.setInteractiveTile();
        playMusic(0);
        gameState = titleState;
        playSpeech(9);
        stopSpeech();
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
//    public void run() {
//        while (gameThread != null) {
//
//            double drawInterval = 1000000000 / 60;
//            double nextDrawTime = System.nanoTime() + drawInterval;
//            long currentTime = System.nanoTime();
//
//            update
//            update();
//            paint
//            repaint();
//            System.out.println("game loop is running");
//
//            try {
//                double remainingTime = nextDrawTime - System.nanoTime();
//                remainingTime=remainingTime/1000000;
//                
//                if(remainingTime<0){
//                    remainingTime=0;
//                }
//                
//                Thread.sleep((long) remainingTime);
//                
//                nextDrawTime+=drawInterval;
//            } catch (InterruptedException ex) {
//                ex.printStackTrace();
//            }
//
//        }
//
//    }

    public void run() {

        double drawInterval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while (gameThread != null) {

            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);

            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
                drawCount++;
            }
            if (timer > 1000000000) {
                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }

        }

    }

    public void update() {

        if (gameState == playState) {
            player.update();

            for (int i = 0; i < npc.length; i++) {
                if (npc[i] != null) {
                    npc[i].update();
                }
            }
            for (int i = 0; i < monster.length; i++) {
                if (monster[i] != null) {
                    if (monster[i].alive == true && monster[i].dying == false) {
                        monster[i].update();
                    }
                    if (monster[i].alive == false) {
                        monster[i].checkDrop();
                        monster[i] = null;
                    }

                }
            }
            for (int i = 0; i < projectileList.size(); i++) {
                if (projectileList.get(i) != null) {
                    if (projectileList.get(i).alive == true) {
                        projectileList.get(i).update();
                    }
                    if (projectileList.get(i).alive == false) {
                        projectileList.remove(i);
                    }

                }
            }
            for(int i = 0; i < iTile.length; i++){
                if (iTile[i] != null) {
                    iTile[i].update();
                }
            }

        }
        if (gameState == pauseState) {

        }
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        //DEBUG
        long drawStart = 0;
        drawStart = System.nanoTime();

        if (gameState == titleState) {

            ui.draw(g2);

        } else {

            //TILE
            TileM.draw(g2);

//            //OBJECTS
//            for (int i = 0; i < obj.length; i++) {
//                if (obj[i] != null) {
//                    obj[i].draw(g2, this);
//                }
//            }
//
//            //NPC
//            for (int i = 0; i < npc.length; i++) {
//                if (npc[i] != null) {
//                    npc[i].draw(g2);
//                }
//            }
//
//            //PLAYER
//            player.draw(g2);
            for(int i = 0; i < iTile.length; i++){
                if (iTile[i] != null) {
                    iTile[i].draw(g2);
                }
            }
            
            // ADD ENTITIES TO THE LIST
            entityList.add(player);

            for (int i = 0; i < npc.length; i++) {
                if (npc[i] != null) {
                    entityList.add(npc[i]);
                }
            }

            for (int i = 0; i < obj.length; i++) {
                if (obj[i] != null) {
                    entityList.add(obj[i]);
                }
            }

            for (int i = 0; i < monster.length; i++) {
                if (monster[i] != null) {
                    entityList.add(monster[i]);
                }
            }

            for (int i = 0; i < projectileList.size(); i++) {
                if (projectileList.get(i) != null) {
                    entityList.add(projectileList.get(i));
                }
            }

            Collections.sort(entityList, new Comparator<Entity>() {
                @Override
                public int compare(Entity e1, Entity e2) {
                    int result = Integer.compare(e1.worldY, e2.worldY);
                    return result;
                }
            });

            // DRAW ENTITIES
            for (int i = 0; i < entityList.size(); i++) {
                entityList.get(i).draw(g2);
            }

            // EMPTY ENTITY LIST
//            for(int i=0; i<entityList.size();i++){
//                entityList.remove(i);
//            }
            entityList.clear();

            //UI
            ui.draw(g2);

        }

        long drawEnd = System.nanoTime();
        long passed = drawEnd - drawStart;
//        g2.setColor(Color.white);
//        g2.drawString("Draw time: "+ passed, 10, 400);
//        System.out.println("Draw time: "+ passed);

        g2.dispose();
    }

    public void playMusic(int i) {

        music.setFile(i);
        music.play();
        music.loop();

    }

    public void stopMusic() {

        music.stop();

    }

    public void playFX(int i) {

        fx.setFile(i);
        fx.play();

    }

    public void playSpeech(int i) {

        speech.setFile(i);
        speech.play();

    }

    public void stopSpeech() {

        speech.stop();

    }
}
