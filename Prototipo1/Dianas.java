// WARNING: This file is auto-generated and any changes to it will be overwritten
import lang.stride.*;
import java.util.*;
import greenfoot.*;
import javax.swing.JOptionPane;
import javax.swing.JInternalFrame;

/**
 * Objetivos a destruir.
 */
public class Dianas extends Actor
{
    private GreenfootSound sonido =  new GreenfootSound("Dianas.mp3");

    /**
     * 
     */
    public Dianas()
    {
        /* Se establecen las dimensiones de las dianas.*/
        GreenfootImage diana = getImage();
        int nuevolargo = (int)diana.getWidth() / 4;
        int nuevah = (int)diana.getHeight() / 4;
        diana.scale(nuevolargo, nuevah);
    }

    /**
     * Método en el que se elimina la diana a la que se hace click, y genera otra en una posición aleatoria, cuyas coordenadas xy no son las mismas que otras dianas existentes.
     */
    public void act()
    {
        if (Greenfoot.mouseClicked(this)) {
            /* Se declara e instancia la nueva diana.*/
            Dianas d =  new Dianas();
            
            /* La imagen de la nueva diana se vuelve invisible.*/
            d.getImage().setTransparency(0);
            
            /* Declaración de un vector que tendrá las nuevas 2 coordenadas de la nueva diana.*/
            int[] coor =  new int[2];
            
            /* Esta función define las coordenadas correctas para la nueva diana.*/
            NuevaDiana(this, coor);
            
            World m1 = getWorld();
            
            /* Se agrega la diana invisible.*/
            m1.addObject(d, coor[0], coor[1]);
            
            
            /* Sonido cuando se destruye la diana.*/
            sonido.play();
            
            /* Se elimina la diana clickeada.*/
            m1.removeObject(this);
            
            MyWorld m2 = (MyWorld)m1;
            
            Counter c = m2.getCounter();
            
            c.Sube();
            
            /* Se vuelve visible la nueva diana.*/
            d.getImage().setTransparency(255);
        }
    }

    /**
     * Método que asigna las nuevas coordenadas de la nueva diana, las cuales no son iguales a las demás.
     */
    public void NuevaDiana(Dianas d, int[] xy)
    {
        boolean b = false;
        
        while ( ! b) {
            b = false;
            xy[0] = Greenfoot.getRandomNumber(15);
            xy[1] = Greenfoot.getRandomNumber(10);
            if ((xy[0] != 5 || xy[1] != 9) && xy[0] != 6) {
                if (xy[0] >= 5) {
                    if (d.getX() != xy[0] || d.getY() != xy[1]) {
                        b = true;
                    }
                }
            }
        }
    }
}
