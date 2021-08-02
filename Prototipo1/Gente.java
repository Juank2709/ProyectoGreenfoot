// WARNING: This file is auto-generated and any changes to it will be overwritten
import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class Gente extends Actor
{

    /**
     * El constructor define las dimensiones de la gente celebrando.
     */
    public Gente()
    {
        GreenfootImage g = getImage();
        int nuevoancho = g.getWidth() / 4;
        int nuevah = g.getHeight() / 6;
        g.scale(nuevoancho, nuevah);
    }
}
