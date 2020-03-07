/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacion;

import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author Sistemas
 */
public class Lienzo extends JPanel {

    Autolavado al;
    ArrayList<Coche> colaCarros;
    int cash = 0;

    public void setAutolavado(Autolavado al) {
        this.al = al;
    }

    public int getCash() {
        return this.cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }
    
    public void addCash(int cash) {
        this.cash += cash;
    }

    Lienzo(ArrayList<Coche> colaCarros) {
        this.colaCarros = colaCarros;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString("$"+cash, 10,10);
        for (int i = 0; i < colaCarros.size(); i++) {
            g.setColor(colaCarros.get(i).getColor());
            g.fillRect(100 * (colaCarros.get(i).getStatus() + 1), 100 + i * 30, 20 * (colaCarros.get(i).getModelo() + 1), 20);
        }
    }

}
