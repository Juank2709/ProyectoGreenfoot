// WARNING: This file is auto-generated and any changes to it will be overwritten
import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class Jacinto extends Actor
{
    private GreenfootSound Error =  new GreenfootSound("Error.mp3");

    /**
     * Se establecen las dimensiones de Jacinto.
     */
    public Jacinto()
    {
        /* Se establecen las dimensiones de Jacinto.*/
        GreenfootImage jac = getImage();
        int nuevolargo = (int)jac.getWidth() / 10;
        int nuevah = 2 * (int)jac.getHeight() / 15;
        jac.scale(nuevolargo, nuevah);
    }

    /**
     * 
     */
    public void act()
    {
        if (Greenfoot.mouseClicked(this)) {
            World m1 = getWorld();
            MyWorld m2 = (MyWorld)m1;
            
            /* Se reproduce el sonido de error.*/
            Error.play();
            
            /* Se reduce el contador.*/
            m2.getCounter().Baja2();
        }
    }
}
