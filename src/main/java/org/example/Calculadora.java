package org.example;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculadora extends JFrame implements ActionListener {

    private JTextField pantalla;
    private double operando1;
    private String operacionPendiente;
    private boolean nuevoNumero = true;

    public Calculadora() {
        super("Calculadora");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());


        // Panel para los botones numéricos
        JPanel panelNumeros = new JPanel(new GridLayout(4, 3));
        // crear botones para los números
        for (int i = 1; i <= 10; i++) {
            JButton boton = new JButton(Integer.toString(i));
            boton.addActionListener(this);
            panelNumeros.add(boton);
        }
        // Botón cero
        JButton boton0 = new JButton("0");
        boton0.addActionListener(this);
        panelNumeros.add(boton0);
        // Botón de punto decimal
        JButton botonPunto = new JButton(".");
        botonPunto.addActionListener(this);
        panelNumeros.add(botonPunto);

        // Panel para los botones de operaciones
        JPanel panelOperaciones = new JPanel(new GridLayout(5, 1));
        String[] operaciones = {"+", "-", "*", "/", "="};
        for (String op : operaciones) {
            JButton boton = new JButton(op);
            boton.addActionListener(this);
            panelOperaciones.add(boton);
        }

        // Panel para la pantalla y los botones
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        pantalla = new JTextField("0", 20);
        pantalla.setEditable(false);
        panelPrincipal.add(pantalla, BorderLayout.NORTH);
        panelPrincipal.add(panelNumeros, BorderLayout.CENTER);
        panelPrincipal.add(panelOperaciones, BorderLayout.EAST);

        // Agregar el panel principal al JFrame
        add(panelPrincipal);

        pack();
        setVisible(true);

        // Centra la ventana en la pantalla del usuario
        setLocationRelativeTo(null);
    }

    public void actionPerformed(ActionEvent evento) {
        String textoBoton = evento.getActionCommand();

        if (textoBoton.equals("C")) {
            // borrar la pantalla
            pantalla.setText("0");
            operando1 = 0;
            operacionPendiente = null;
            nuevoNumero = true;
        } else if (textoBoton.equals("+") || textoBoton.equals("-") || textoBoton.equals("*") || textoBoton.equals("/")) {
            // guardar la operación pendiente y el primer operando
            operacionPendiente = textoBoton;
            operando1 = Double.parseDouble(pantalla.getText());
            nuevoNumero = true;
        } else if (textoBoton.equals("=")) {
            // realizar la operación pendiente con el segundo operando
            double operando2 = Double.parseDouble(pantalla.getText());
            double resultado = 0;

            if (operacionPendiente.equals("+")) {
                resultado = operando1 + operando2;
            } else if (operacionPendiente.equals("-")) {
                resultado = operando1 - operando2;
            } else if (operacionPendiente.equals("*")) {
                resultado = operando1 * operando2;
            } else if (operacionPendiente.equals("/")) {
                resultado = operando1 / operando2;
            }

            // mostrar el resultado en la pantalla
            pantalla.setText(Double.toString(resultado));
            operacionPendiente = null;
            nuevoNumero = true;
        } else {
            // añadir el número al final del número actual en la pantalla
            if (nuevoNumero) {
                pantalla.setText(textoBoton);
                nuevoNumero = false;
            } else {
                pantalla.setText(pantalla.getText() + textoBoton);
            }
        }
    }

    public static void main(String[] args) {
        new Calculadora();
    }
}