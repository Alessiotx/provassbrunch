/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.corsa_cavalli_2;

/**
 *
 * @author Alessio
 */
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class Cavallo extends Thread {
    private String nome;
    private int velocita; // metri al secondo
    private int distanzaPercorsa = 0;
    private boolean infortunato = false;
    private int distanzaTotale;

    public Cavallo(String nome, int velocita, int distanzaTotale) {
        this.nome = nome;
        this.velocita = velocita;
        this.distanzaTotale = distanzaTotale;
    }

    public void run() {
        Random random = new Random();
        while (distanzaPercorsa < distanzaTotale && !infortunato) {
            try {
                // Simula il movimento del cavallo per un secondo
                Thread.sleep(1000);
                // Possibilità di infortunio: 10% di probabilità
                if (random.nextInt(100) < 10) {
                    infortunato = true;
                    System.out.println(nome + " si è infortunato e non può continuare!");
                } else {
                    distanzaPercorsa += velocita;
                    System.out.println(nome + " ha percorso " + distanzaPercorsa + " metri.");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public String getNome() {
        return nome;
    }

    public int getDistanzaPercorsa() {
        return distanzaPercorsa;
    }

    public boolean isInfortunato() {
        return infortunato;
    }
}


}