/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.corsa_cavalli_2;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Alessio
 */
public class GaraCavalli {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Cavallo> cavalli = new ArrayList<>();

        System.out.print("Inserisci il numero di cavalli partecipanti: ");
        int numeroCavalli = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Inserisci la distanza totale della gara in metri: ");
        int distanzaTotale = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numeroCavalli; i++) {
            System.out.print("Inserisci il nome del cavallo " + (i + 1) + ": ");
            String nome = scanner.nextLine();

            System.out.print("Inserisci la velocità (m/s) del cavallo " + nome + ": ");
            int velocita = scanner.nextInt();
            scanner.nextLine(); // Consumare la newline rimasta

            Cavallo cavallo = new Cavallo(nome, velocita, distanzaTotale);
            cavalli.add(cavallo);
        }

        // Avvia i thread dei cavalli
        for (Cavallo cavallo : cavalli) {
            cavallo.start();
        }

        // Attendi la fine di tutti i thread
        for (Cavallo cavallo : cavalli) {
            try {
                cavallo.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Ordina i cavalli per distanza percorsa in ordine decrescente
        cavalli.sort(Comparator.comparingInt(Cavallo::getDistanzaPercorsa).reversed());

        // Stampa la classifica dei primi 3 cavalli
        System.out.println("\nClassifica finale:");
        for (int i = 0; i < Math.min(3, cavalli.size()); i++) {
            Cavallo cavallo = cavalli.get(i);
            System.out.println((i + 1) + ". " + cavallo.getNome() + " - Distanza percorsa: " + cavallo.getDistanzaPercorsa() + " metri" +
                    (cavallo.isInfortunato() ? " (Infortunato)" : ""));
        }

        // Salva la classifica in un file scelto dall'utente
        System.out.print("\nInserisci il nome del file per salvare i risultati (es. classifica.txt): ");
        String nomeFile = scanner.nextLine();

        try (FileWriter writer = new FileWriter(nomeFile, true)) {
            writer.write("Classifica della gara:\n");
            for (int i = 0; i < Math.min(3, cavalli.size()); i++) {
                Cavallo cavallo = cavalli.get(i);
                writer.write((i + 1) + ". " + cavallo.getNome() + " - Distanza percorsa: " + cavallo.getDistanzaPercorsa() + " metri" +
                        (cavallo.isInfortunato() ? " (Infortunato)" : "") + "\n");
            }
            writer.write("\n");
            System.out.println("Risultati salvati con successo nel file " + nomeFile);
        } catch (IOException e) {
            System.out.println("Errore durante il salvataggio nel file: " + e.getMessage());
        }

        scanner.close();
    }

    private static class Cavallo {

      
    }
