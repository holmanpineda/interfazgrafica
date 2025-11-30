package triqui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menu extends JFrame {
    private JPanel panelPrincipal;
    private JLabel lbltitulo;
    private JButton btnTriqui;
    private JButton btnparejas;
    private JButton btnahorcado;
    private JButton btncalculadora;
    private JButton btnsalir;

    public menu() {
        setContentPane(panelPrincipal);
        setTitle("Menu de Juegos");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 450);
        setLocationRelativeTo(null);

        // Botón Triqui
        btnTriqui.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                triqui juego = new triqui();
                juego.setVisible(true);
            }
        });

        // Botón Ahorcado
        btnahorcado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Juego Ahorcado - Próximamente");
            }
        });

        // Botón Parejas
        btnparejas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Juego Parejas - Próximamente");
            }
        });

        // Botón Calculadora
        btncalculadora.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Calculadora - Próximamente");
            }
        });

        // Botón Salir
        btnsalir.addActionListener(new ActionListener() {
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
                menu menuPrincipal = new menu();
                menuPrincipal.setVisible(true);
            }
        });
    }
}