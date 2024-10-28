/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.corsa_cavalli;

/**
 *
 * @author Alessio
 */
import java.util.Random;

public class Cavallo extends Thread {
    private String nome;
    private int distanzaPercorsa = 0;
    private int lunghezzaPercorso;
    private static boolean garaFinita = false;

    public Cavallo(String nome, int lunghezzaPercorso) {
        this.nome = nome;
        this.lunghezzaPercorso = lunghezzaPercorso;
    }

    @Override
    public void run() {
        Random random = new Random();
        
        // Simula la corsa del cavallo
        while (distanzaPercorsa < lunghezzaPercorso && !garaFinita) {
            // Ad ogni step il cavallo corre un numero casuale di metri (tra 1 e 10)
            int metriCorsi = random.nextInt(10) + 1;
            distanzaPercorsa += metriCorsi;
            
            // Visualizza il progresso del cavallo
            System.out.println(nome + " ha percorso " + distanzaPercorsa + " metri.");

            // Verifica se il cavallo ha raggiunto la fine del percorso
            if (distanzaPercorsa >= lunghezzaPercorso) {
                garaFinita = true;
                System.out.println(nome + " ha vinto la gara!");
            }
            
            // Ritardo per simulare il tempo di corsa
            try {
                Thread.sleep(500); // 500 millisecondi
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}