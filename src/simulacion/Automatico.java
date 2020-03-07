/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacion;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Random;

/**
 *
 * @author Sistemas
 */
public class Automatico extends Thread {

    boolean status = false;
    Autolavado al;
    Lienzo lienzo;
    Random r = new Random();

    Automatico(Autolavado al, Lienzo lienzo) {
        this.al = al;
        this.lienzo=lienzo;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void run() {
        while (true) {
            try {
                while (status) {
                    Thread.sleep(200 * (r.nextInt(30) + 1));
                    if (r.nextInt(2) == 0) {
                        al.addCarro(new Coche(0, 0));
                    } else {
                        al.addCarro(new Coche(0, 1));
                    }
                    lienzo.repaint();
                }
                Thread.sleep(200);
            } catch (InterruptedException ex) {
                Logger.getLogger(Autolavado.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
