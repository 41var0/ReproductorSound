package reprodutor;


import javax.swing.JSlider;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author usuario
 */
public class SliderProgressBar extends Thread {

    private final JSlider slider; // "final" modificado opr NetBeans
    public boolean isStoped = false;

    /**
     * Constructor
     *
     * @param slider
     */
    public SliderProgressBar(JSlider slider) {
        this.slider = slider;
    }

    /**
     * La clase esta especificamente creada solo para mover el slider a modo de
     * barra de progreso
     */
    @Override
    public void run() {
        System.out.println("The slider is changing ");
        // El programa funciona fenemenel        
        for (int sec = 0; sec <= slider.getMaximum() && !isStoped; sec++) {
            try {
                slider.setValue(sec);
                System.out.println("The file is in " + sec + " of " + slider.getMaximum() + " seconds");
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println("ERROR: The slider is not working :D");
            }
        }

        SoundReproductor.isPlaying = false;

    }

}
