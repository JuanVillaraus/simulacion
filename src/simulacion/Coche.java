/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacion;

import java.awt.Color;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sistemas
 */
public class Coche {

    int id;
    int modelo;//0.-carro personal, 1.-Camion
    int status;//0.-en espera, 1.-lavando, 2.-secando, 3.-encerado 4.-aspirado 5.-entregado
    boolean disponible = true;
    Color color;

    public void setStatus(int status) {
        this.status = status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getStatus() {
        return this.status;
    }

    public int getId() {
        return this.id;
    }

    public int getModelo() {
        return this.modelo;
    }
    
    public boolean getDisponible() {
        return this.disponible;
    }

    public Color getColor() {
        return this.color;
    }

    public Coche(int id, int modelo) {
        this.id = id;
        this.modelo = modelo;
        int r = (int) (0xff * Math.random());
        int g = (int) (0xff * Math.random());
        int b = (int) (0xff * Math.random());

        this.color = new Color(r,g,b);
    }
}
