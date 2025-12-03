package Triqui.UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Triqui.UI.TicTacToeFrame;
import Ahorcado.Ahorcado;
import Calculadora.CalculatorFrame;
import Parejas.MemoryGameFrame;

public class Menu extends JFrame {
    private JPanel panelPrincipal;
    private JLabel lblTitulo;
    private JButton btnTriqui;
    private JButton btnAhorcado;
    private JButton btnParejas;
    private JButton btnCalculadora;
    private JButton btnSalir;

    public Menu() {
        setContentPane(panelPrincipal);
        setTitle("Menu de Juegos");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 500);
        setLocationRelativeTo(null);

        // Botón Triqui
        btnTriqui.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TicTacToeFrame juego = new TicTacToeFrame();
                juego.setVisible(true);
            }
        });

        // Botón Ahorcado
        btnAhorcado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ahorcado juego = new Ahorcado();
                juego.setVisible(true);
            }
        });

        // Botón Parejas
        btnParejas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MemoryGameFrame juego = new MemoryGameFrame();
                juego.setVisible(true);
            }
        });

        // Botón Calculadora
        btnCalculadora.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CalculatorFrame calc = new CalculatorFrame();
                calc.setVisible(true);
            }
        });

        // Botón Salir
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int respuesta = JOptionPane.showConfirmDialog(
                        null,
                        "¿Está seguro que desea salir?",
                        "Confirmar salida",
                        JOptionPane.YES_NO_OPTION
                );
                if (respuesta == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Menu menuPrincipal = new Menu();
                menuPrincipal.setVisible(true);
            }
        });
    }
}