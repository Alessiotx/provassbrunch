/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ufficio_postale;

import java.util.concurrent.ExecutorService;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Alessio
 */
public class SimulazioneUfficioPostale {
    public static void main(String[] args) {
        Ufficio_postale ufficioPostale = new Ufficio_postale();
        ExecutorService executor = Executors.newFixedThreadPool(3); 

        
        executor.execute(() -> {
            while (ufficioPostale.haClienti()) {
                try {
                    ufficioPostale.arrivaCliente();
                    TimeUnit.MILLISECONDS.sleep(500 + new Random().nextInt(500)); 
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

       
        Runnable sportelloTask = () -> {
            while (ufficioPostale.haClienti()) {
                try {
                    ListaClienti cliente = Ufficio_postale.chiamaProssimoCliente();
                    if (cliente != null) {
                        System.out.println("Servendo cliente con numero: " + cliente.getNumero());
                        TimeUnit.MILLISECONDS.sleep(1000 + new Random().nextInt(1000)); 
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };

      
        executor.execute(sportelloTask);
        executor.execute(sportelloTask);

        executor.shutdown();
        try {
            executor.awaitTermination(10, TimeUnit.MINUTES); 
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Simulazione completata.");
    }
}

