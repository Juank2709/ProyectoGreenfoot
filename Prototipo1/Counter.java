// WARNING: This file is auto-generated and any changes to it will be overwritten
import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class Counter extends Actor
{
    /* Contador de los puntos.*/
    public int scr = 0;
    
    /* Contador secundario de las dianas destruidas consecutivamente (streak).*/
    public int streak = 0;

    /**
     * Se establecen las dimensiones del cuadro donde se desplegarán los puntos.
     */
    public Counter()
    {
        GreenfootImage ctr = getImage();
        int nuevoancho = 17 * ctr.getWidth() / 10;
        int nuevah = 13 * ctr.getHeight() / 10;
        ctr.scale(nuevoancho, nuevah);
    }

    /**
     * Act - do whatever the Counter wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        getWorld().showText("Pts: " + scr, 11, 10);
        getWorld().showText("Streak x" + streak, 13, 10);
    }

    /**
     * 
     */
    public void Sube()
    {
        scr = scr + 5;
        streak = streak + 1;
    }

    /**
     * Método que disminuye el contador puntos cuando toca el mundo.
     */
    public void Baja()
    {
        if (scr > 0) {
            scr = scr - 5;
            streak = 0;
        }
    }

    /**
     * Método que disminuye significativamente el contador de puntos cuando toca a Jacinto.
     */
    public void Baja2()
    {
        /* Si el puntaje es mayor a 10, entonces puede reducirlo en esa cantidad.*/
        if (scr >= 10) {
            scr = scr - 10;
            streak = 0;
        }
        else {
            /* Si el puntaje es menor a 10, simplemente lo inicializa a 0.*/
            scr = 0;
            streak = 0;
        }
    }
}
