/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ufficiopostale;

/**
 *
 * @author Alessio
 */
public class Arrivi implements Runnable{
    private ListaClienti listaClienti;
    private final int attesaArrivi=2000;
    
    public Arrivi(ListaClienti listaClienti){
        this.listaClienti=listaClienti;
        
    }
    
    public void run(){
        try{
            while(!Thread.interrupted()){
                Thread.sleep(attesaArrivi);
                Integer clienteArrivato=listaClienti.addCliente();
                if(clienteArrivato==null) break;
                System.out.println("Arrivo Cliente Numero \t " + clienteArrivato);
            }
        } catch(InterruptedException e){
            System.out.println("Thread interrotto durante lo sleep");
        } finally {
            System.out.println("Posta Chiusa");
        }
    }
}
