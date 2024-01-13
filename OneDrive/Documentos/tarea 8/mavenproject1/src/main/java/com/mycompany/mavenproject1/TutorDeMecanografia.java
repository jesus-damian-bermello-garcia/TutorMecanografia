/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 *
 * @author Damian BG
 */
public class TutorDeMecanografia extends JFrame {

    private JTextArea textArea;
    private JLabel pangramaLabel;
    private JButton imprimirButton;

    private List<String> pangramas;
    private String pangramaActual;

    private int posicionActualPangrama;
    private int posicionActualTecla;

    private List<Character> pulsacionesCorrectas;
    private List<Character> pulsacionesIncorrectas;
    private Set<Character> teclasProblematicas;

    public TutorDeMecanografia() {

        setTitle("Tutor de Mecanografía");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 400);

        textArea = new JTextArea();
        textArea.setEditable(false);

        pangramaLabel = new JLabel();
        pangramaLabel.setHorizontalAlignment(SwingConstants.CENTER);

        imprimirButton = new JButton("Imprimir");
        imprimirButton.addActionListener(new ImprimirButtonListener());

        JPanel keyboardPanel = new JPanel(new GridLayout(4, 10));

        String[] keyboardChars = {
                "Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P",
                "A", "S", "D", "F", "G", "H", "J", "K", "L", "Espacio",
                "Z", "X", "C", "V", "B", "N", "M"
        };

        for (String keyChar : keyboardChars) {
            JButton keyButton = new JButton(keyChar);
            keyButton.addActionListener(new KeyButtonListener());
            keyButton.addMouseListener(new KeyButtonMouseListener());
            keyboardPanel.add(keyButton);
        }

 
        cargarPangramasDesdeArchivo("pangramas.txt");

        pulsacionesCorrectas = new ArrayList<>();
        pulsacionesIncorrectas = new ArrayList<>();
        teclasProblematicas = new HashSet<>();

        mostrarPangramaAleatorio();

        add(textArea, BorderLayout.CENTER);
        add(pangramaLabel, BorderLayout.NORTH);
        add(imprimirButton, BorderLayout.EAST);
        add(keyboardPanel, BorderLayout.SOUTH);
    }

    private class KeyButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton sourceButton = (JButton) e.getSource();
            String keyChar = sourceButton.getText();

            verificarTecla(keyChar.charAt(0));
        }
    }


    private class KeyButtonMouseListener extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            JButton sourceButton = (JButton) e.getSource();
            String keyChar = sourceButton.getText();

            sourceButton.setBackground(Color.GREEN);

            if (keyChar.equals("Espacio")) {
                textArea.append(" ");
            } else {
                textArea.append(keyChar);
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            JButton sourceButton = (JButton) e.getSource();

            sourceButton.setBackground(null);
        }
    }

    private class ImprimirButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            imprimirResultados();
            System.exit(0); 
        }
    }


    private void cargarPangramasDesdeArchivo(String nombreArchivo) {
        pangramas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                pangramas.add(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Collections.shuffle(pangramas);
    }

    private void mostrarPangramaAleatorio() {
        if (!pangramas.isEmpty()) {
            pangramaActual = pangramas.get(0);
            pangramaLabel.setText(pangramaActual);

            posicionActualPangrama = 0;
            posicionActualTecla = 0;
        }
    }

    private void verificarTecla(char tecla) {
        if (pangramaActual != null && posicionActualPangrama < pangramaActual.length()) {
            char charPangrama = pangramaActual.charAt(posicionActualPangrama);

            if (tecla == charPangrama) {
                pulsacionesCorrectas.add(tecla);
            } else {
                pulsacionesIncorrectas.add(tecla);
                teclasProblematicas.add(charPangrama);
            }

            posicionActualPangrama++;

            if (posicionActualPangrama == pangramaActual.length()) {
                mostrarPangramaAleatorio();
            }
        }
    }

    private void imprimirResultados() {
        System.out.println("Resultados:");
        System.out.println("Pangrama: " + pangramaActual);
        System.out.println("Pulsaciones Correctas: " + pulsacionesCorrectas.size() + " - " + pulsacionesCorrectas);
        if (!pulsacionesIncorrectas.isEmpty()) {
            System.out.println("Pulsaciones Incorrectas: " + pulsacionesIncorrectas);
        }
        if (!teclasProblematicas.isEmpty()) {
            System.out.println("Teclas Problemáticas: " + teclasProblematicas);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TutorDeMecanografia tutor = new TutorDeMecanografia();
            tutor.setVisible(true);
        });
    }
}

