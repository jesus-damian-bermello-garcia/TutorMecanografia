/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject1;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

/**
 *
 * @author Damian BG
 */
public class TutorDeMecanografia extends JFrame {
    
    private JTextArea textArea;
    private JLabel pangramaLabel;
    private JButton imprimirButton;

    public TutorMecanografia() {
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
    }
}
