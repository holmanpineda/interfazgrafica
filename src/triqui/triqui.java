package triqui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class triqui extends JFrame {
    private JPanel panelprincipal;
    private JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    private JLabel lblestado;
    private JButton btnReiniciar;

    private String turnoActual = "X";
    private int movimientos = 0;

    public triqui() {
        setContentPane(panelprincipal);
        setTitle("Juego de Triqui");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 600);
        setLocationRelativeTo(null);

        // Configurar acciones de los botones del tablero
        configurarBoton(btn1);
        configurarBoton(btn2);
        configurarBoton(btn3);
        configurarBoton(btn4);
        configurarBoton(btn5);
        configurarBoton(btn6);
        configurarBoton(btn7);
        configurarBoton(btn8);
        configurarBoton(btn9);

        // Acción del botón reiniciar
        btnReiniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reiniciarJuego();
            }
        });
    }

    private void configurarBoton(JButton boton) {
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (boton.getText().equals("")) {
                    boton.setText(turnoActual);
                    boton.setEnabled(false);
                    movimientos++;

                    if (verificarGanador()) {
                        lblestado.setText("¡Ganó " + turnoActual + "!");
                        deshabilitarTodos();
                    } else if (movimientos == 9) {
                        lblestado.setText("¡Empate!");
                    } else {
                        turnoActual = turnoActual.equals("X") ? "O" : "X";
                        lblestado.setText("Turno: " + turnoActual);
                    }
                }
            }
        });
    }

    private boolean verificarGanador() {
        // Verificar filas
        if (verificarLinea(btn1, btn2, btn3)) return true;
        if (verificarLinea(btn4, btn5, btn6)) return true;
        if (verificarLinea(btn7, btn8, btn9)) return true;

        // Verificar columnas
        if (verificarLinea(btn1, btn4, btn7)) return true;
        if (verificarLinea(btn2, btn5, btn8)) return true;
        if (verificarLinea(btn3, btn6, btn9)) return true;

        // Verificar diagonales
        if (verificarLinea(btn1, btn5, btn9)) return true;
        if (verificarLinea(btn3, btn5, btn7)) return true;

        return false;
    }

    private boolean verificarLinea(JButton b1, JButton b2, JButton b3) {
        String t1 = b1.getText();
        String t2 = b2.getText();
        String t3 = b3.getText();

        return !t1.equals("") && t1.equals(t2) && t2.equals(t3);
    }

    private void deshabilitarTodos() {
        btn1.setEnabled(false);
        btn2.setEnabled(false);
        btn3.setEnabled(false);
        btn4.setEnabled(false);
        btn5.setEnabled(false);
        btn6.setEnabled(false);
        btn7.setEnabled(false);
        btn8.setEnabled(false);
        btn9.setEnabled(false);
    }

    private void reiniciarJuego() {
        btn1.setText(""); btn1.setEnabled(true);
        btn2.setText(""); btn2.setEnabled(true);
        btn3.setText(""); btn3.setEnabled(true);
        btn4.setText(""); btn4.setEnabled(true);
        btn5.setText(""); btn5.setEnabled(true);
        btn6.setText(""); btn6.setEnabled(true);
        btn7.setText(""); btn7.setEnabled(true);
        btn8.setText(""); btn8.setEnabled(true);
        btn9.setText(""); btn9.setEnabled(true);

        turnoActual = "X";
        movimientos = 0;
        lblestado.setText("Turno: X");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                triqui juego = new triqui();
                juego.setVisible(true);
            }
        });
    }
}

