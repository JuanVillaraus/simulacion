/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacion;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sistemas
 */
public class AreaLavado extends Thread {

    int id;
    Lienzo lienzo;
    Autolavado al;
    int timeWaitCar = 1;
    int timeWaitBus = 1;

    AreaLavado(int id, Autolavado al, Lienzo lienzo, int timeWaitCar, int timeWaitBus) {
        System.out.println("hi I'm lavado#" + id);
        this.id = id;
        this.al = al;
        this.lienzo = lienzo;
        this.timeWaitCar = timeWaitCar;
        this.timeWaitBus = timeWaitBus;
    }
    
    public void setTimeWaitCar(int timeWaitCar){
        this.timeWaitCar = timeWaitCar;
    }
    
    public void setTimeWaitBus(int timeWaitBus){
        this.timeWaitBus = timeWaitBus;
    }

    public void run() {
        System.out.println("run lavado" + id);
        boolean done = false;
        while (true) {
            try {
                if (al.colaCarros.size() > 0) {
                    for (int i = 0; i < al.colaCarros.size(); i++) {
                        if (al.colaCarros.get(i).status == 0) {
                            if (al.colaCarros.get(i).getDisponible()) {
                                al.colaCarros.get(i).setDisponible(false);
                                System.out.println("\t\tcarro #" + i + " será lavado por #" + id);
                                al.colaCarros.get(i).setStatus(1);
                                lienzo.repaint();
                                if (al.colaCarros.get(i).getModelo() == 0) {
                                    Thread.sleep(1000 * timeWaitCar);
                                } else {
                                    Thread.sleep(1000 * timeWaitBus);
                                }
                                al.colaCarros.get(i).setDisponible(true);
                                i = al.colaCarros.size();
                                done = true;
                            }
                        }
                    }
                    if (!done) {
                        Thread.sleep(200);
                    } else {
                        done = false;
                    }
                } else {
                    Thread.sleep(1000);
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Autolavado.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
