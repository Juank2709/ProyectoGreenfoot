// WARNING: This file is auto-generated and any changes to it will be overwritten
import lang.stride.*;
import java.util.*;
import greenfoot.*;
import javax.swing.JOptionPane;
import javax.swing.JInternalFrame;

/**
 * 
 */
public class Timer extends Actor
{
    private int timer = 3000;

    /**
     * 
     */
    public Timer()
    {
        /* Se establecen las dimensiones de la caja que tendrá el tiempo que sobra.*/
        GreenfootImage timer = getImage();
        int nuevoancho = 4 * timer.getWidth() / 5;
        int nuevah = 4 * timer.getHeight() / 5;
        timer.scale(nuevoancho, nuevah);
    }

    /**
     * Método que reduce el tiempo en 1 unidad mientras se ejecute el programa.
     */
    public int Reducir()
    {
        timer = timer - 1;
        return timer;
    }

    /**
     * Método en el que si aún queda tiempo, se muestra en la pantalla y se reduce, y que cuando se acaba, se detiene el programa.
     */
    public void act()
    {
        if (Reducir() > 0) {
            getWorld().showText(Reducir() / 100 + "", 8, 10);
        }
        else {
            World m1 = getWorld();
            MyWorld m2 = (MyWorld)m1;
            
            if (m2.getCounter().scr < 300) {
                /* Mensaje de motivación.*/
                JOptionPane.showMessageDialog( new JInternalFrame(), "No llegaste al objetivo esta vez, pero sigue practicando con el arco y flecha, y pronto alcanzarás la meta y se hará justicia para Jacinto.", "¡Pronto lo lograrás!", JOptionPane.INFORMATION_MESSAGE);
            }
            else {
                /* Mensaje de victoria.*/
                JOptionPane.showMessageDialog( new JInternalFrame(), "¡Lo lograste! Gracias a ti, Jacinto le explicó todo al rey y se ha hecho justicia para él. El que lo incriminó irá a la cárcel y él regresó a ser el soldado real más noble del reino.", "Victoria", JOptionPane.INFORMATION_MESSAGE);
                
                /* Se agrega el objeto de la gente celebrando si Jacinto gana.*/
                getWorld().addObject( new Gente(), 2, 10);
            }
            
            /* Se detiene el programa del juego.*/
            Greenfoot.stop();
        }
    }
}
