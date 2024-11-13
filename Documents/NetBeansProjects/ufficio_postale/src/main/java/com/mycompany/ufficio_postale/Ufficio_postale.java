/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ufficio_postale;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
/**
 *
 * @author Alessio
 */

public class Ufficio_postale {

   private final Queue<ListaClienti> codaClienti = new LinkedList<>();
    private final int maxClienti = 100;
    private int numeroCliente = 1;
    private final Random random = new Random();

    public synchronized void arrivaCliente() {
        if (numeroCliente <= maxClienti) {
            ListaClienti cliente = new ListaClienti(numeroCliente++);
            codaClienti.add(cliente);
            System.out.println("Arrivato cliente con numero: " + cliente.getNumero());
            notifyAll(); // Notifica gli sportelli che c'è un nuovo cliente
        }
    }

    public synchronized ListaClienti chiamaProssimoCliente() throws InterruptedException {
        while (codaClienti.isEmpty()) {
            wait(); // Attende finché la coda non ha clienti
        }
        return codaClienti.poll();
    }

    public boolean haClienti() {
        return numeroCliente <= maxClienti || !codaClienti.isEmpty();
    }
}
