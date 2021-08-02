// WARNING: This file is auto-generated and any changes to it will be overwritten
import lang.stride.*;
import java.util.*;
import greenfoot.*;
import javax.swing.JOptionPane;
import javax.swing.JInternalFrame;

/**
 * 
 */
public class MyWorld extends World
{
    /* Variable global necesaria para desplegar el puntaje y el mensaje dependiendo si logró el objetivo o no.*/
    public Counter ctr =  new Counter();
    
    /* Variable que contiene la música para el juego y del error en el tiro.*/
    private GreenfootSound Fondo =  new GreenfootSound("Audio_Juego.mp3");
    private GreenfootSound Error =  new GreenfootSound("Error.mp3");

    /**
     * Constructor for objects of class MyWorld.
     */
    public MyWorld()
    {
        super(20, 11, 60);
        /* Se establece el fondo.*/
        setBackground("Cuadro.jpg");
        
        /* Se agregan las primeras 3 dianas, las 2 torres, Jacinto y el timer.*/
        AgregarActores();
        
        /* Mensaje con la historia de Jacinto.*/
        JOptionPane.showMessageDialog( new JInternalFrame(), "Eres Jacinto de NotreDame, y has sido incriminado...Te llevan a la cárcel, pero escapas...Ves el afiche de una competencia que ofrece al ganador una visita con el rey. ¡Destruya la mayor cantidad de dianas que puedas!", "Historia", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog( new JInternalFrame(), "La meta son 300 puntos.", "Historia", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Método que agrega los actores en el mundo.
     */
    private void AgregarActores()
    {
        /* Instancias de los actores a agregar en el mundo.*/
        Jacinto jac =  new Jacinto();
        Torre torre1 =  new Torre();
        Torre torre2 =  new Torre();
        Timer t =  new Timer();
        
        /* Se agrega Jacinto*/
        addObject(jac, 5, 10);
        
        /* Se agregan las dos torres para fondo del mundo.*/
        addObject(torre1, 2, 5);
        addObject(torre2, 17, 5);
        
        /* Se agrega el timer.*/
        addObject(t, 8, 10);
        
        /* Se agrega el counter al mundo.*/
        addObject(ctr, 11, 10);
        PrimerasDianas();
    }

    /**
     * Método del mundo que hace coloca las 3 primeras dianas del nivel
     */
    private void PrimerasDianas()
    {
        Dianas[] ds =  new Dianas[3];
        int i = 0;
        
        /* Se hace 3 veces.*/
        while (i < ds.length) {
            ds[i] =  new Dianas();
            boolean b = false;
            int x = 0;
            int y = 0;
            
            /* Ciclo que asigna coordendas xy tantas veces como sea necesario con el fin de que cumplan las condiciones: estar dentro del rango y no ser las mismas que las de Jacinto (5, 9).*/
            while ( ! b) {
                x = Greenfoot.getRandomNumber(15);
                y = Greenfoot.getRandomNumber(10);
                if (((x != 5) || (y != 9)) && x != 6) {
                    if (x >= 5) {
                        if (i == 0) {
                            b = true;
                        }
                        else {
                            b = NoRepetidos(x, y, i, ds);
                        }
                    }
                }
            }
            /* Si se cumple que los coordenadas estén dentro de los rengos, agrega el objeto.*/
            addObject(ds[i], x, y);
            
            /* Incremento de la variable del ciclo principal.*/
            i = i + 1;
        }
    }

    /**
     * Método que hace que las coordenadas de las 3 primeras dianas no sean las mismas.
     */
    private boolean NoRepetidos(int x, int y, int i, Dianas[] d)
    {
        if (i == 1) {
            if ((d[0].getX() != x) && (d[0].getY() != y)) {
                return true;
            }
            else {
                return false;
            }
        }
        else {
            int k = 0;
            boolean b = true;
            while ((k < i) && b) {
                if ((d[k].getX() == x) && (d[k].getY() == y)) {
                    b = false;
                }
                k = k + 1;
            }
            return b;
        }
    }

    /**
     * 
     */
    public Counter getCounter()
    {
        return ctr;
    }

    /**
     * 
     */
    public void act()
    {
        /* Para que la música suene a la vez que el juego corra.*/
        Fondo.play();
        
        /* En caso de que le hagan click al mundo, bajan los puntos.*/
        if (Greenfoot.mouseClicked(this)) {
            Error.play();
            ctr.Baja();
        }
    }
}
