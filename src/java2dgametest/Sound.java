package java2dgametest;

import java.io.File;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {

    Clip clip;
    URL soundURL[] = new URL[30];
    File file[]=new File[30];

    public Sound() {
        
        soundURL[0]=getClass().getClassLoader().getResource("res/sound/gra.wav");
        soundURL[1]=getClass().getClassLoader().getResource("res/sound/ciach.wav");
        soundURL[2]=getClass().getClassLoader().getResource("res/sound/bum1.wav");
        soundURL[3]=getClass().getClassLoader().getResource("res/sound/bum1.wav");
        soundURL[4]=getClass().getClassLoader().getResource("res/sound/fanfary.wav");
        soundURL[5]=getClass().getClassLoader().getResource("res/sound/gra.wav");
//        soundURL[6]=getClass().getClassLoader().getResource("res/sound/");
//        soundURL[7]=getClass().getClassLoader().getResource("res/sound/");
        soundURL[8]=getClass().getClassLoader().getResource("res/sound/bum2.wav");
        soundURL[9]=getClass().getClassLoader().getResource("res/sound/end.wav");
//        soundURL[10]=getClass().getClassLoader().getResource("res/sound/");
//        soundURL[11]=getClass().getClassLoader().getResource("res/sound/");
        soundURL[12]=getClass().getClassLoader().getResource("res/sound/plum.wav");
        soundURL[13]=getClass().getClassLoader().getResource("res/sound/dzwon.wav");
//        soundURL[14]=getClass().getClassLoader().getResource("res/sound/");
        soundURL[15]=getClass().getClassLoader().getResource("res/sound/plum2.wav");
        
    }
    public void setFile(int i){
        
        try{
            
            AudioInputStream ais=AudioSystem.getAudioInputStream(soundURL[i]);
            clip=AudioSystem.getClip();
            clip.open(ais);
            
        }catch(Exception e){
            
        }
    }
    public void play(){
        
        clip.start();
        
    }
    public void loop(){
        
        clip.loop(Clip.LOOP_CONTINUOUSLY);
        
    }
    public void stop(){
        
        clip.stop();
        
    }

}
