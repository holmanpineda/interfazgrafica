package Ahorcado;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

public class Ahorcado extends JFrame {
    private JPanel panelPrincipal;
    private JLabel labelPalabra;
    private JTextField textFieldLetra;
    private JButton btnAdivinar;
    private JLabel labelMensaje;
    private JButton btnNuevoJuego;
    private JLabel labelDibujo;

    private String palabraSecreta;
    private char[] palabraActual;
    private int intentosRestantes;
    private List<Character> letrasUsadas;
    private String[] palabras = {"PROGRAMACION", "JAVA", "COMPUTADORA", "TECLADO", "MONITOR"};

    private String[] dibujos = {
            "  +---+\n  |   |\n      |\n      |\n      |\n      |\n=========",
            "  +---+\n  |   |\n  O   |\n      |\n      |\n      |\n=========",
            "  +---+\n  |   |\n  O   |\n  |   |\n      |\n      |\n=========",
            "  +---+\n  |   |\n  O   |\n /|   |\n      |\n      |\n=========",
            "  +---+\n  |   |\n  O   |\n /|\\  |\n      |\n      |\n=========",
            "  +---+\n  |   |\n  O   |\n /|\\  |\n /    |\n      |\n=========",
            "  +---+\n  |   |\n  O   |\n /|\\  |\n / \\  |\n      |\n========="
    };

    public Ahorcado() {
        // Configurar la ventana
        setContentPane(panelPrincipal);
        setTitle("Juego del Ahorcado");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(500, 600);
        setLocationRelativeTo(null);

        // Iniciar el juego
        iniciarJuego();

        btnAdivinar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adivinarLetra();
            }
        });

        btnNuevoJuego.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarJuego();
            }
        });

        textFieldLetra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adivinarLetra();
            }
        });
    }

    private void iniciarJuego() {
        Random random = new Random();
        palabraSecreta = palabras[random.nextInt(palabras.length)];
        palabraActual = new char[palabraSecreta.length()];
        Arrays.fill(palabraActual, '_');
        intentosRestantes = 6;
        letrasUsadas = new ArrayList<>();

        actualizarPantalla();
        labelMensaje.setText("¡Adivina la palabra!");
        textFieldLetra.setEnabled(true);
        btnAdivinar.setEnabled(true);
    }

    private void adivinarLetra() {
        String entrada = textFieldLetra.getText().toUpperCase();
        textFieldLetra.setText("");

        if (entrada.length() != 1) {
            labelMensaje.setText("Por favor, introduce solo una letra");
            return;
        }

        char letra = entrada.charAt(0);

        if (letrasUsadas.contains(letra)) {
            labelMensaje.setText("Ya usaste esa letra");
            return;
        }

        letrasUsadas.add(letra);

        boolean acierto = false;
        for (int i = 0; i < palabraSecreta.length(); i++) {
            if (palabraSecreta.charAt(i) == letra) {
                palabraActual[i] = letra;
                acierto = true;
            }
        }

        if (!acierto) {
            intentosRestantes--;
            labelMensaje.setText("Letra incorrecta. Intentos restantes: " + intentosRestantes);
        } else {
            labelMensaje.setText("¡Bien! Letra correcta");
        }

        actualizarPantalla();
        verificarFinJuego();
    }

    private void actualizarPantalla() {
        StringBuilder palabraMostrar = new StringBuilder();
        for (char c : palabraActual) {
            palabraMostrar.append(c).append(" ");
        }
        labelPalabra.setText(palabraMostrar.toString());

        int indice = 6 - intentosRestantes;
        labelDibujo.setText("<html><pre>" + dibujos[indice] + "</pre></html>");
    }

    private void verificarFinJuego() {
        if (intentosRestantes == 0) {
            labelMensaje.setText("¡Perdiste! La palabra era: " + palabraSecreta);
            textFieldLetra.setEnabled(false);
            btnAdivinar.setEnabled(false);
        } else if (new String(palabraActual).equals(palabraSecreta)) {
            labelMensaje.setText("¡GANASTE! ¡Felicitaciones!");
            textFieldLetra.setEnabled(false);
            btnAdivinar.setEnabled(false);
        }
    }
}