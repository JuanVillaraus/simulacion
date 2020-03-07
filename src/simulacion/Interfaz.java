/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacion;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author Sistemas
 */
public class Interfaz extends JFrame implements ActionListener {

    JPanel pMain = new JPanel();
    Autolavado al;
    Coche coche;
    Automatico automatico;
    int ticket = 0;
    int cola = 0;
    ArrayList<Coche> colaCarros = new ArrayList<Coche>();
    Lienzo lienzo = new Lienzo(colaCarros);
    JButton btn1 = new JButton("Coche");
    JButton btn2 = new JButton("Camion");
    JTextField tTimeLavadoCar = new JTextField(5);
    JTextField tTimeLavadoBus = new JTextField(5);
    JTextField tTimeSecadoCar = new JTextField(5);
    JTextField tTimeSecadoBus = new JTextField(5);
    JTextField tTimeEnceradoCar = new JTextField(5);
    JTextField tTimeEnceradoBus = new JTextField(5);
    JTextField tTimeAspiradoCar = new JTextField(5);
    JTextField tTimeAspiradoBus = new JTextField(5);
    int NumeroDeAreasDeLavado = 2;
    int NumeroDeAreasDeSecado = 2;
    int NumeroDeAreasDeEncerado = 2;
    int NumeroDeAreasDeAspirado = 2;
    int costoPorCarro = 80;
    int costoPorCamion = 150;
    JFrame config;

    public Interfaz() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width / 2) - this.getWidth() / 2,
                (Toolkit.getDefaultToolkit().getScreenSize().height / 3) - this.getHeight() / 2);
        this.setTitle("Autolavado v1.0");
        tTimeLavadoCar.setText("15");
        tTimeLavadoBus.setText("20");
        tTimeSecadoCar.setText("7");
        tTimeSecadoBus.setText("10");
        tTimeEnceradoCar.setText("10");
        tTimeEnceradoBus.setText("15");
        tTimeAspiradoCar.setText("15");
        tTimeAspiradoBus.setText("20");
        JPanel pModo = new JPanel();
        JPanel pNoLavado = new JPanel();
        JPanel pNoSecado = new JPanel();
        JPanel pNoEncerado = new JPanel();
        JPanel pNoAspirado = new JPanel();
        JButton config = new JButton("Configuración");
        JRadioButton rModo0 = new JRadioButton("Random", false);
        JRadioButton rModo1 = new JRadioButton("Manual", true);
        ButtonGroup modo = new ButtonGroup();
        modo.add(rModo0);
        modo.add(rModo1);
        pModo.add(rModo0);
        pModo.add(rModo1);
        pNoLavado.add(tTimeLavadoCar);
        pNoSecado.add(tTimeSecadoCar);
        pNoEncerado.add(tTimeEnceradoCar);
        pNoAspirado.add(tTimeAspiradoCar);
        pModo.setBorder(BorderFactory.createTitledBorder("Modo"));
        pNoLavado.setBorder(BorderFactory.createTitledBorder("No lavado"));
        pNoSecado.setBorder(BorderFactory.createTitledBorder("No secado"));
        pNoEncerado.setBorder(BorderFactory.createTitledBorder("No encerado"));
        pNoAspirado.setBorder(BorderFactory.createTitledBorder("No aspirado"));
        config.addActionListener(this);
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        rModo0.addActionListener(this);
        rModo1.addActionListener(this);

//        al = new Autolavado(lienzo, colaCarros, 4, 3, 4, 2, 15, 20, 7, 10, 10, 15, 15, 20, 80, 150);
        al = new Autolavado(lienzo, colaCarros, NumeroDeAreasDeLavado,
                NumeroDeAreasDeSecado, NumeroDeAreasDeEncerado, NumeroDeAreasDeAspirado,
                Integer.valueOf(tTimeLavadoCar.getText()),
                Integer.valueOf(tTimeLavadoBus.getText()),
                Integer.valueOf(tTimeSecadoCar.getText()),
                Integer.valueOf(tTimeSecadoBus.getText()),
                Integer.valueOf(tTimeEnceradoCar.getText()),
                Integer.valueOf(tTimeEnceradoBus.getText()),
                Integer.valueOf(tTimeAspiradoCar.getText()),
                Integer.valueOf(tTimeAspiradoBus.getText()),
                costoPorCarro, costoPorCamion);
        automatico = new Automatico(al, lienzo);
        automatico.start();
        pMain.add(pModo);
        pMain.add(btn1);
        pMain.add(btn2);
        pMain.add(config);
//        pMain.add(pNoLavado);
//        pMain.add(pNoSecado);
//        pMain.add(pNoEncerado);
//        pMain.add(pNoAspirado);
        this.add(pMain, BorderLayout.NORTH);
        this.add(lienzo);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("event " + e.getActionCommand());
        switch (e.getActionCommand()) {
            case "Coche":
                System.out.println("coche #" + ticket + " a la cola");
                coche = new Coche(ticket, 0);
                ticket++;
                al.addCarro(coche);
                break;
            case "Camion":
                System.out.println("camion #" + ticket + " a la cola");
                coche = new Coche(ticket, 1);
                ticket++;
                al.addCarro(coche);
                break;
            case "Configuración":
                JPanel pConfig = new JPanel();
//                JTextField tUser = new JTextField(8);
//                JPasswordField tPass = new JPasswordField(8);
                pConfig.add(new JLabel("Lavado carro:"));
                pConfig.add(tTimeLavadoCar);
                pConfig.add(new JLabel("Lavado camion:"));
                pConfig.add(tTimeLavadoBus);
                pConfig.add(new JLabel("Secado carro:"));
                pConfig.add(tTimeSecadoCar);
                pConfig.add(new JLabel("Secado camion:"));
                pConfig.add(tTimeSecadoBus);
                pConfig.add(new JLabel("Encerado carro:"));
                pConfig.add(tTimeEnceradoCar);
                pConfig.add(new JLabel("Encerado camion:"));
                pConfig.add(tTimeEnceradoBus);
                pConfig.add(new JLabel("Aspirado carro:"));
                pConfig.add(tTimeAspiradoCar);
                pConfig.add(new JLabel("Aspirado camion:"));
                pConfig.add(tTimeAspiradoBus);
                if (0 == JOptionPane.showConfirmDialog(null, pConfig, "Configurar el tiempo de espera", JOptionPane.DEFAULT_OPTION)) {
                    al.setTimeWait(Integer.valueOf(tTimeLavadoCar.getText()), Integer.valueOf(tTimeLavadoBus.getText()),
                            Integer.valueOf(tTimeSecadoCar.getText()), Integer.valueOf(tTimeSecadoBus.getText()),
                            Integer.valueOf(tTimeEnceradoCar.getText()), Integer.valueOf(tTimeEnceradoBus.getText()),
                            Integer.valueOf(tTimeAspiradoCar.getText()), Integer.valueOf(tTimeAspiradoBus.getText()));
                }
                break;

            case "Manual":
                btn1.setEnabled(true);
                btn2.setEnabled(true);
                automatico.setStatus(false);
                break;
            case "Random":
                btn1.setEnabled(false);
                btn2.setEnabled(false);
                automatico.setStatus(true);
                break;
        }
        lienzo.repaint();
    }
}
