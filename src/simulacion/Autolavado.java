/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacion;

import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sistemas
 */
public class Autolavado {// extends Thread {

    Lienzo lienzo;
    ArrayList<Coche> colaCarros;// = new ArrayList<Coche>();
    ArrayList<AreaLavado> areaLavado = new ArrayList<AreaLavado>();
    ArrayList<AreaSecado> areaSecado = new ArrayList<AreaSecado>();
    ArrayList<AreaEncerado> areaEncerado = new ArrayList<AreaEncerado>();
    ArrayList<AreaAspirado> areaAspirado = new ArrayList<AreaAspirado>();
    int ticket = 0;

    public Autolavado(Lienzo lienzo, ArrayList<Coche> colaCarros, int NumeroDeAreasDeLavado,
            int NumeroDeAreasDeSecado, int NumeroDeAreasDeEncerado, int NumeroDeAreasDeAspirado, int tiempodeEsperaLavadoCarro,
            int tiempoDeEsperaLavadoCamion, int tiempoDeEsperaSecadoCarro, int tiempoEsperaSecadoCamion,
            int tiempoDeEsperaEnceradoCarro, int tiempoDeEsperaEnceradoCamion, int tiempoDeEsperaAspiradoCarro,
            int tiempoDeEsperaAspiradoCamion, int costoPorCarro, int costoPorCamion) {
        this.lienzo = lienzo;
        this.colaCarros = colaCarros;

        //Segmento dónde se crean las áreas
        for (int i = 0; i < NumeroDeAreasDeLavado; i++) {
            areaLavado.add(new AreaLavado(i, this, lienzo, tiempodeEsperaLavadoCarro, tiempoDeEsperaLavadoCamion));
        }
        for (int i = 0; i < NumeroDeAreasDeSecado; i++) {
            areaSecado.add(new AreaSecado(i, this, lienzo, tiempoDeEsperaSecadoCarro, tiempoEsperaSecadoCamion));
        }
        for (int i = 0; i < NumeroDeAreasDeEncerado; i++) {
            areaEncerado.add(new AreaEncerado(i, this, lienzo, tiempoDeEsperaEnceradoCarro, tiempoDeEsperaEnceradoCamion));
        }
        for (int i = 0; i < NumeroDeAreasDeAspirado; i++) {
            areaAspirado.add(new AreaAspirado(i, this, lienzo, tiempoDeEsperaAspiradoCarro, tiempoDeEsperaAspiradoCamion,
                    costoPorCarro, costoPorCamion));
        }

        //segmento dónde se pone a correr los hilos de las áreas
        for (int i = 0; i < NumeroDeAreasDeLavado; i++) {
            areaLavado.get(i).start();
        }
        for (int i = 0; i < NumeroDeAreasDeSecado; i++) {
            areaSecado.get(i).start();
        }
        for (int i = 0; i < NumeroDeAreasDeEncerado; i++) {
            areaEncerado.get(i).start();
        }
        for (int i = 0; i < NumeroDeAreasDeAspirado; i++) {
            areaAspirado.get(i).start();
        }
    }

    public void addCarro(Coche carro) {
        colaCarros.add(carro);
    }

    public int getTicket() {
        System.out.println("getTicket");
        return this.ticket;
    }

    public void nextTicket() {
        this.ticket++;
    }

    public void setTimeWait(int timeLavadoCar, int timeLavadoBus,
            int timeSecadoCar, int timeSecadoBus, int timeEnceradoCar,
            int timeEnceradoBus, int timeAspiradoCar, int timeAspiradoBus) {
        for (int i = 0; i < areaLavado.size(); i++) {
            areaLavado.get(i).setTimeWaitCar(timeLavadoCar);
            areaLavado.get(i).setTimeWaitBus(timeLavadoBus);
        }
        for (int i = 0; i < areaSecado.size(); i++) {
            areaSecado.get(i).setTimeWaitCar(timeSecadoCar);
            areaSecado.get(i).setTimeWaitBus(timeSecadoBus);
        }
        for (int i = 0; i < areaEncerado.size(); i++) {
            areaEncerado.get(i).setTimeWaitCar(timeEnceradoCar);
            areaEncerado.get(i).setTimeWaitBus(timeEnceradoBus);
        }
        for (int i = 0; i < areaAspirado.size(); i++) {
            areaAspirado.get(i).setTimeWaitCar(timeAspiradoCar);
            areaAspirado.get(i).setTimeWaitBus(timeAspiradoBus);
        }
    }
}
