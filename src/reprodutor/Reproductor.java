package reprodutor;


import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JSlider;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author DAM2
 */
public class Reproductor {
    
    SliderProgressBar progressSlider;
    AudioInputStream ais;
    Clip clip;
    boolean isPlayeable = false;
    
    public Reproductor() {
    }

    /**
     * Pone el slider que se va a utilizar como barra de progreso
     *
     * @param nuevoSlider
     */
    public void setSlider(JSlider nuevoSlider) {
        progressSlider = new SliderProgressBar(nuevoSlider);
    }

    /**
     * cambia el archivo de reproduccion y settea al minimo el volumen
     *
     * @param nuevoArchivo
     */
    public void cambiarArchivo(File nuevoArchivo) {
        
        try {
            clip = AudioSystem.getClip();
            ais = AudioSystem.getAudioInputStream(nuevoArchivo);
            
            clip.open(ais);
            isPlayeable = true;
            
        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
            isPlayeable = false;
            
        }
    }

    /**
     * Cambia el volumen de la musica
     * https://stackoverflow.com/questions/953598/audio-volume-control-increase-or-decrease-in-java
     *
     * @param nuevoVolumen
     */
    public void cambiarVolumen(float nuevoVolumen) {
        
        if (isPlayeable) {
            FloatControl controlVoluemn = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN); // Control de volumen
            controlVoluemn.setValue(nuevoVolumen);
            
        }
    }

    // Empieza la musica
    public void empezarMusica() {
        clip.start();
        progressSlider.start();
        
    }

    // Para la musica y mas
    public void pararMusica() {
        clip.stop();
        progressSlider.isStoped = true;
        //barraProgreso.stop();
    }

    /**
     * Devuelve la duracion del archivo
     * https://stackoverflow.com/questions/49547408/how-to-set-a-jslider-to-the-duration-of-an-audio-file
     *
     * @return
     */
    public int getDuracion() {
        int duration;
        
        float frameRate = ais.getFormat().getFrameRate();
        float frameCount = ais.getFrameLength();
        
        duration = Math.round((frameCount) / frameRate);
        
        return duration;
    }
    
 
    
}
