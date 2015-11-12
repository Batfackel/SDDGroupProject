package Model;

import java.applet.Applet;
import java.applet.AudioClip;

public class Sound {

    public static final Sound sound1 = new Sound("/sounds//frantic.wav");
    public static final Sound shot = new Sound("/sounds//shot.wav");
    public static final Sound shot2 = new Sound("/sounds//laser.wav");
    public static final Sound shot3 = new Sound("/sounds//teleport.wav");
    public static final Sound dead = new Sound("/sounds//explosion.wav");
    private AudioClip clip;

    public Sound(String fileName) {

        try {
            clip = Applet.newAudioClip(Sound.class.getResource(fileName));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loop() {
        try {
            new Thread() {
                public void run() {
                    clip.loop();
                }
            }.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public  void play() {
        try {
            new Thread() {
                public void run() {
                    clip.play();
                }
            }.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void stop() {
        try {
            new Thread() {
                public void run() {
                    clip.stop();
                }
            }.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
     public void mute() {
        try {
            new Thread() {
                public void run() {
                    clip.stop();
                }
            }.start();
        } catch (Exception e) {
            e.printStackTrace();
        }    
    }
    
    
}

