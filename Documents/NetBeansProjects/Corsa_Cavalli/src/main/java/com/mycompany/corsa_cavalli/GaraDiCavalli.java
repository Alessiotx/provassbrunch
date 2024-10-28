/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.corsa_cavalli;

/**
 *
 * @author Alessio
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GaraDiCavalli {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ottieni la lunghezza del percorso
        System.out.print("Inserisci la lunghezza del percorso della gara (in metri): ");
        int lunghezzaPercorso = scanner.nextInt();
        scanner.nextLine(); // Consuma il newline dopo l'intero

        // Ottieni il numero di cavalli
        System.out.print("Inserisci il numero di cavalli: ");
        int numeroCavalli = scanner.nextInt();
        scanner.nextLine(); // Consuma il newline dopo l'intero

        List<Cavallo> cavalli = new ArrayList<>();

        // Ottieni i nomi dei cavalli
        for (int i = 1; i <= numeroCavalli; i++) {
            System.out.print("Inserisci il nome del cavallo " + i + ": ");
            String nomeCavallo = scanner.nextLine();
            cavalli.add(new Cavallo(nomeCavallo, lunghezzaPercorso));
        }

        // Inizia la gara
        System.out.println("\nLa gara è iniziata!\n");

        for (Cavallo cavallo : cavalli) {
            cavallo.start();
        }

        // Attendi che tutti i cavalli finiscano la corsa
        for (Cavallo cavallo : cavalli) {
            try {
                cavallo.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("\nLa gara è terminata!");
        scanner.close();
    }
}