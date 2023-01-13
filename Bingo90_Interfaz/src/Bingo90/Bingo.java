package Bingo90;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.border.MatteBorder;

public class Bingo extends JFrame {

    private ArrayList<Integer> bolaList; 
    private Tablero tablero;    
    private JLabel lblNumeroAleatorio;    
    private JButton btnSacarBola;
    
    public Bingo() {
    	getContentPane().setBackground(new Color(255, 165, 0));
        setTitle("Bingo");    
        setSize(833, 676);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      
        getContentPane().setLayout(null);

        bolaList = new ArrayList<Integer>();
        for (int i = 1; i <= 90; i++) {
        	bolaList.add(i);
        }
        Collections.shuffle(bolaList);
        tablero = new Tablero();
        tablero.setBackground(new Color(0, 255, 255));
        tablero.setBounds(192, 115, 583, 511);
        tablero.setSacados(bolaList);
        getContentPane().add(tablero);

        lblNumeroAleatorio = new JLabel();
        lblNumeroAleatorio.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
        lblNumeroAleatorio.setForeground(new Color(0, 0, 0));
        lblNumeroAleatorio.setFont(new Font("Dialog", Font.PLAIN, 36));
        lblNumeroAleatorio.setBounds(210, 0, 415, 104);
        getContentPane().add(lblNumeroAleatorio);

        btnSacarBola = new JButton("Sacar bola");
        btnSacarBola.setForeground(new Color(255, 255, 255));
        btnSacarBola.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
        btnSacarBola.setBackground(new Color(0, 0, 128));
        btnSacarBola.setFont(new Font("Tahoma", Font.PLAIN, 22));
        btnSacarBola.setBounds(10, 189, 149, 95);
        btnSacarBola.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (bolaList.size() > 0 && !tablero.tablaLlena()) {
                    int numero = bolaList.remove(0);

                    lblNumeroAleatorio.setText(Integer.toString(numero));
                    tablero.marcarNumero(numero);
                } else {
                btnSacarBola.setEnabled(false);             
                }
                }
                });
                getContentPane().add(btnSacarBola);
                JButton btnTerminarJuego = new JButton("Salir del Juego");
                btnTerminarJuego.setForeground(new Color(255, 255, 255));
                btnTerminarJuego.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
                btnTerminarJuego.setBackground(new Color(0, 0, 139));
                btnTerminarJuego.setFont(new Font("Tahoma", Font.PLAIN, 22));
                btnTerminarJuego.setBounds(632, 16, 185, 90);
                btnTerminarJuego.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        dispose();
                    }
                });
                getContentPane().add(btnTerminarJuego);

                JLabel lblBingo90 = new JLabel("Bingo");
                lblBingo90.setBackground(Color.BLACK);
                lblBingo90.setForeground(new Color(0, 0, 255));
                lblBingo90.setFont(new Font("Times New Roman", Font.BOLD, 74));
                lblBingo90.setBounds(10, 0, 190, 90);
                getContentPane().add(lblBingo90);
            }

            public static void main(String[] args) {
            	Bingo bingo = new Bingo();
            	bingo.setVisible(true);
            	}
         }