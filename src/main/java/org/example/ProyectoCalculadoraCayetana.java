package org.example;

import javax.swing.*;
import java.awt.*;

public class ProyectoCalculadoraCayetana extends JFrame {

    private JTextField pantalla;
    private double operando1;
    private String operacionPendiente;
    private boolean nuevoNumero = true;

    public ProyectoCalculadoraCayetana() {

        super("Calculadora");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panelNumeros = new JPanel(new GridLayout(4, 4));

        GridLayout layout = new GridLayout(3, 3);
        layout.setHgap(10);
        layout.setVgap(10);

        for (int i = 1; i < 10; i++) {
            add(new Button(Integer.toString(i)));

            // Muestra la ventana ajustada al tamaño de sus componentes
            pack();
            setVisible(true);

        }
    }


    public static void main(String[] args) {
        new ProyectoCalculadoraCayetana();
    }
}
