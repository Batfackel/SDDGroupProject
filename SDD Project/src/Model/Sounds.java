/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

/**
 *
 * @author brian
 */
import java.applet.Applet;
import java.applet.AudioClip;

public class Sounds {

    public static final Sounds sound1 = new Sounds("/frantic.wav");
    public static final Sounds sound2 = new Sounds("/laser.wav");

    
    private AudioClip clip;

    public Sounds (String fileName) {

        try {
//            clip = Applet.newAudioClip(Sounds.class.getResource(fileName));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void play() {

        clip.play();
    }
    
    public void loop() {
//        clip.loop();
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
}

