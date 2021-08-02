// WARNING: This file is auto-generated and any changes to it will be overwritten
import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class Torre extends Actor
{
    private GreenfootSound Error =  new GreenfootSound("Error.mp3");

    /**
     * Se establecen las dimensiones de las torres.
     */
    public Torre()
    {
        /* Se establecen las dimensiones de la torre.*/
        GreenfootImage t = getImage();
        int nuevoancho = (t.getWidth() * 3) / 2;
        int nuevah = (t.getHeight() * 6) / 2;
        t.scale(nuevoancho, nuevah);
    }

    /**
     * Método que si detecta un click en las torres, baja puntos y reinicia el streak.
     */
    public void act()
    {
        if (Greenfoot.mouseClicked(this)) {
            MyWorld m = (MyWorld)getWorld();
            Error.play();
            m.getCounter().Baja2();
        }
    }
}
